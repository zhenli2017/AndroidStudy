package com.konka.androidstudy.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 点击三要素 :
 * button.setOnClickListener(new View.OnClickListener() {
 *
 * @Override public void onClick(View v) {
 * <p>
 * }
 * });
 * 1.方法名 : setOnClickListener
 * 2.对象.txt  : View.OnClickListener
 * 3.执行的方法 : onClick
 */
@Target(ElementType.ANNOTATION_TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BaseOnClick {
    //方法名
    String listenerName();

    //对象.txt
    Class<?> listenerType();

    //执行的方法
    String listenerMethod();
}
