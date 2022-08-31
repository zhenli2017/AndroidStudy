package com.konka.androidstudy.focus;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.Random;

public class TouchView extends View implements View.OnClickListener {
    public TouchView(Context context) {
        super(context);
        init();
    }

    public TouchView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TouchView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(this);
        setClickable(false);
    }

    int number = new Random(100).nextInt();

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("TouchView dispatchTouchEvent MotionEvent.ACTION_DOWN " + number);

//                ((ViewGroup)getParent()).requestDisallowInterceptTouchEvent(true);
               break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("TouchView dispatchTouchEvent MotionEvent.ACTION_MOVE " + number);
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("TouchView dispatchTouchEvent MotionEvent.ACTION_UP " + number);
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("TouchView dispatchTouchEvent MotionEvent.ACTION_CANCEL " + number);
                break;
        }
        return super.dispatchTouchEvent(ev);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("TouchView onTouchEvent MotionEvent.ACTION_DOWN " + number);
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("TouchView onTouchEvent MotionEvent.ACTION_MOVE " + number);
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("TouchView onTouchEvent MotionEvent.ACTION_UP " + number);
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("TouchView onTouchEvent MotionEvent.ACTION_CANCEL " + number);
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        System.out.println("onCLick TouchView");
    }
}
