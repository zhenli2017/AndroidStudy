package com.konka.lib;


public class MyClass {

    public MyClass() {
        System.out.println("===2");
    }

    {
        System.out.println("===1");
    }



    public static void main(String[] args) {
MyClass myClass = new MyClass();
    }



}