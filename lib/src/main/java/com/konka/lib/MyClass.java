package com.konka.lib;


import java.io.Serializable;

public class MyClass {


    public static class A {

        public void out() {
            System.out.println("out " + this.getClass().getSimpleName());
        }
    }

    public static class B extends A implements Serializable {


    }


    public static void main(String[] args) {
        new B().out();
    }


}