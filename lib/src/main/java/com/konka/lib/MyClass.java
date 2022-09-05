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

        Thread thread_1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("======= 1");
            }
        });
        Thread thread_2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    thread_1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("====== 2");
            }
        });
        thread_1.start();
        thread_2.start();



    }

}