package com.konka.androidstudy.annotation;

import android.view.View;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ListenerInvocationHandler implements InvocationHandler {


    //需要在Onclick中执行listener.onClick()
    private Object activity;
    private Method activityMethod;
    private View view;

    public ListenerInvocationHandler(Object activity, Method activityMethod, View view) {
        this.activity = activity;
        this.activityMethod = activityMethod;
        this.view = view;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        return activityMethod.invoke(activity, view);
    }
}
