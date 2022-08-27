package com.konka.androidstudy.annotation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.konka.androidstudy.R;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnotationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_annotation);

        ClickListenerInject.inject(this);
        Button button =findViewById(R.id.button_2);
//        button.setOnLongClickListener(new View.OnLongClickListener() {
//            @Override
//            public boolean onLongClick(View v) {
//                return false;
//            }
//        });

        try {
            Method setOnLongClickListener = button.getClass().getMethod("setOnLongClickListener", View.OnLongClickListener.class);
            Object invoke = setOnLongClickListener.invoke(button,new View.OnLongClickListener(){

                @Override
                public boolean onLongClick(View v) {
                    System.out.println("==============");
                    return false;
                }
            });
            System.out.println("invoke = "+invoke);


        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}
