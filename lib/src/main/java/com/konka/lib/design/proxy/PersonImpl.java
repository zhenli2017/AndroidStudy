package com.konka.lib.design.proxy;

public class PersonImpl implements ProxyPerson, ProxyPerson2 {
    @Override
    public void run(String name) {
        System.out.println("PersonImpl = " + name);
    }

    @Override
    public void test1() {
        System.out.println("PersonImpl = test1");
    }

    @Override
    public void run() {
        System.out.println("PersonImpl = run ");
    }

    @Override
    public void test2() {
        System.out.println("PersonImpl = test2");
    }
}
