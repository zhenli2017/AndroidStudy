package com.konka.lib.design.proxy;

import java.lang.reflect.Proxy;

/**
 * 动态代理 :
 * classloader : 使用那个类加载,当这个类被回收的时候,被加载的类也会回收
 * interface : 传入要实现的接口,可以传多个,必须是接口,不能是普通类
 * invocationHandler : 当调用接口的方法时,回回调这个接口中的invoke()方法
 * <p>
 * (newProxyInstance instanceof ProxyPerson) -> true
 * (newProxyInstance instanceof ProxyPerson2) -> true
 * <p>
 * 1.Proxy.newProxyInstance(_,_,_)  回动态的生成一个$Proxy0 的对象,这个对象继承Proxy,同时实现了所有刚才我们传入的interface接口
 * 2.通过 : newProxyInstance.getClass().getName() 可以查看,如果直接打印 newProxyInstance 会显示null
 * 3.在生成 $Proxy0 对象时构造函数会传入我们的invocationHandler对象
 * 4.当我们通过 newProxyInstance 调用方法时,其实会调用 super.h.invoke()方法,所以会执行invoke()方法
 * <p>
 * 5.invoke()方法中的proxy不能打印,如果要打印需要判断投string,否则会Stack Overflow
 */
public class ProxyMain {
    public static void main(String[] args) {
        PersonInvocationHandler personInvocationHandler = new PersonInvocationHandler(new PersonImpl());
        Object newProxyInstance = Proxy.newProxyInstance(personInvocationHandler.getClass().getClassLoader(), new Class[]{ProxyPerson.class, ProxyPerson2.class}, personInvocationHandler);
        System.out.println("newProxyInstance newProxyInstance = " + newProxyInstance.getClass().getName());
        System.out.println("newProxyInstance tostring = " + newProxyInstance.toString());
        System.out.println("newProxyInstance ProxyPerson = " + (newProxyInstance instanceof ProxyPerson));
        System.out.println("newProxyInstance ProxyPerson2 = " + (newProxyInstance instanceof ProxyPerson2));
        ((ProxyPerson) newProxyInstance).run("ProxyPerson");
        ((ProxyPerson) newProxyInstance).test1();
        ((ProxyPerson2) newProxyInstance).run();
        ((ProxyPerson2) newProxyInstance).test2();

    }


}
