package com.konka.lib;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class MyClass {


    public static class A {
        int a = 10;

        @Override
        public String toString() {
            return "A{" +
                    "a=" + a +
                    '}';
        }
    }

    public static class B extends A implements Serializable {

        int b = 100;

        @Override
        public String toString() {
            return "B{" +
                    "b=" + b +
                    "a=" + a +
                    '}';
        }
    }


    public static void main(String[] args) {

        B b = new B();
        b.b = 101;
        b.a = 11;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ObjectOutputStream outputStream = new ObjectOutputStream(byteArrayOutputStream);
            outputStream.writeObject(b);
            outputStream.flush();
            outputStream.close();

            byte[] bytes = byteArrayOutputStream.toByteArray();
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);

            ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
            B readObject = (B) objectInputStream.readObject();
            objectInputStream.close();

            System.out.println("readObject = " + readObject);


        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}