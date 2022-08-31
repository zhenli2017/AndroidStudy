package com.konka.androidstudy.focus;

import android.os.Bundle;
import android.os.Parcel;
import android.view.MotionEvent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.konka.androidstudy.R;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;

public class FocusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_focus);
        byte[] bytes = new byte[1024 * 1024 * 10];
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.gc();
            }
        });
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<String, String>(0,0.75f,true);
        linkedHashMap.put("1","1");
        linkedHashMap.put("2","2");
        System.out.println("linkedHashMap = "+linkedHashMap);
        ReferenceQueue<String> referenceQueue = new ReferenceQueue<>();
        WeakReference<String> weakReference = new WeakReference<>("AAAA",referenceQueue);

        Parcel.obtain();
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }
}