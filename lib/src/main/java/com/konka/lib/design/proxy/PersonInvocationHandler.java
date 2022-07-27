package com.konka.lib.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Arrays;

public class PersonInvocationHandler implements InvocationHandler {

    private Object target;

    public PersonInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
//        System.out.println("PersonInvocationHandler o = " + o);
        //调用接口的方法
        System.out.println("PersonInvocationHandler method = " + method);
        //调用接口的参数
        System.out.println("PersonInvocationHandler objects = " + Arrays.deepToString(objects));
        //这里执行的时候内容是不固定的
        //可以传入一个对象,随便一个接口,只要执行,那么就执行对象上的方法
        //也可以通过判断method,根据不同的方法执行不同的内容
        return method.invoke(target, objects);
    }
}
