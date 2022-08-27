package com.konka.androidstudy.annotation;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@BaseOnClick(listenerName = "setOnClickListener", listenerType = View.OnClickListener.class, listenerMethod = "onClick")
public @interface OnClick {

    int[] value();
    String[] AAA() ;
}
