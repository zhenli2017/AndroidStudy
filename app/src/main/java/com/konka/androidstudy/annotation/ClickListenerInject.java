package com.konka.androidstudy.annotation;

import android.view.View;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class ClickListenerInject {


    public static void inject(Object object) {
        if (object == null) {
            throw new NullPointerException("inject Object null");
        }
        //反射加载类的方式
//        Class.forName("com.konka.androidstudy.annotation.AnnotationActivity"); //完整的包名和类名
//        AnnotationActivity.class.getClass();
        Class<?> aClass = object.getClass();
        //反射处理方法
        handleMethod(object, aClass);


    }

    private static void handleClass() {

    }

    private static void handleField() {

    }

    private static void handleMethod(Object object, Class<?> aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            handleOnClick(object, aClass, method);
        }
    }

    private static void handleOnClick(Object object, Class<?> aClass, Method method) {
        //获取方法上的注解
        OnClick onClickClass = method.getAnnotation(OnClick.class);
        //判断方法上是否有对应的注解
        boolean isAnnotationPresent = method.isAnnotationPresent(OnClick.class);
        System.out.println("ClickListenerInject method Name = " + method.getName());
        System.out.println("ClickListenerInject method getAnnotation = " + onClickClass);
        System.out.println("ClickListenerInject method isAnnotationPresent = " + isAnnotationPresent);
        if (onClickClass == null) {
            return;
        }
        //获取注解上的注解,也就是获取元注解
        Class<? extends Annotation> annotationType = onClickClass.annotationType();
        BaseOnClick annotationTypeAnnotation = annotationType.getAnnotation(BaseOnClick.class);
        if (annotationTypeAnnotation == null) {
            return;
        }
        //获取元注解的值
        String listenerMethod = annotationTypeAnnotation.listenerMethod();
        String listenerName = annotationTypeAnnotation.listenerName();
        Class<?> listenerType = annotationTypeAnnotation.listenerType();

        //直接获取注解上的值
        int[] value = onClickClass.value();
        //通过反射获取注解上的方法,然后获取方法的值
        try {
            Method declaredMethod = onClickClass.getClass().getDeclaredMethod("value");
            int[] viewId = (int[]) declaredMethod.invoke(onClickClass);
            System.out.println("ClickListenerInject BaseOnClick viewId int[] = " + Arrays.toString(value));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            for (int id : value) {
                //通过activity的class对象获取findViewById()方法
                Method findViewById = aClass.getMethod("findViewById", int.class);
                //执行方法获取view
                View view = (View) findViewById.invoke(object, id);
                if (view == null) {
                    continue;
                }
                //创建动态代理
                ListenerInvocationHandler listenerInvocationHandler = new ListenerInvocationHandler(object, method, view);
                Object proxyInstance = Proxy.newProxyInstance(listenerInvocationHandler.getClass().getClassLoader(), new Class[]{listenerType}, listenerInvocationHandler);
                System.out.println("proxyInstance = "+proxyInstance);
                //setOnLongClickListener(new View.OnLongClickListener()) 相当于这一句代码
                Method onClickMethod = view.getClass().getMethod(listenerName, listenerType);
                //执行onCLick方法,然后交给动态代理执行activity的onCLick()方法
                //本来这里需要传入一个new View.OnLongClickListener() 的实现类,因为参数是这个,但是这里传入代理,相当于代理做了点击
                onClickMethod.invoke(view, proxyInstance);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static void handleMethodParams(Object object, Class<?> aClass) {
        Method[] declaredMethods = aClass.getDeclaredMethods();
        for (Method method : declaredMethods) {
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();

        }

    }
}
