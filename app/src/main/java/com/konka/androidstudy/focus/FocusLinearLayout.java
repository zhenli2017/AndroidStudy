package com.konka.androidstudy.focus;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class FocusLinearLayout extends LinearLayout implements View.OnClickListener {
    public FocusLinearLayout(@NonNull Context context) {
        super(context);
        init();
    }

    public FocusLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FocusLinearLayout(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setOnClickListener(this);
        setDescendantFocusability(FOCUS_BLOCK_DESCENDANTS);
    }
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        System.out.println("dispatchKeyEvent getAction = " + event.getAction() + " getKeyCode = " + event.getKeyCode());
        return super.dispatchKeyEvent(event);
    }

    @Override
    public View focusSearch(int direction) {
        System.out.println("focusSearch = " + direction);
        return super.focusSearch(direction);
    }

    @Override
    public View focusSearch(View focused, int direction) {
        System.out.println("focusSearch focused = " + focused + " direction = " + direction);
        return super.focusSearch(focused, direction);
    }

    @Override
    public void requestChildFocus(View child, View focused) {
        super.requestChildFocus(child, focused);
        System.out.println("requestChildFocus child = " + child + " focused = " + focused);
    }

    @Override
    public boolean requestFocus(int direction, Rect previouslyFocusedRect) {
        System.out.println("requestFocus");
        return super.requestFocus(direction, previouslyFocusedRect);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction) {
        super.addFocusables(views, direction);
        System.out.println("addFocusables views = " + views + " direction = " + direction);
    }

    @Override
    public void addFocusables(ArrayList<View> views, int direction, int focusableMode) {
        super.addFocusables(views, direction, focusableMode);
        System.out.println("addFocusables views = " + views + " direction = " + direction + " focusableMode = " + focusableMode);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("FocusLinearLayout dispatchTouchEvent MotionEvent.ACTION_DOWN");
              break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("FocusLinearLayout dispatchTouchEvent MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("FocusLinearLayout dispatchTouchEvent MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("FocusLinearLayout dispatchTouchEvent MotionEvent.ACTION_CANCEL");
                break;
        }
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        switch (ev.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("FocusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_DOWN");
               break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("FocusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("FocusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("FocusLinearLayout onInterceptTouchEvent MotionEvent.ACTION_CANCEL");
                break;
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                System.out.println("FocusLinearLayout onTouchEvent MotionEvent.ACTION_DOWN");
                break;
            case MotionEvent.ACTION_MOVE:
                System.out.println("FocusLinearLayout onTouchEvent MotionEvent.ACTION_MOVE");
                break;
            case MotionEvent.ACTION_UP:
                System.out.println("FocusLinearLayout onTouchEvent MotionEvent.ACTION_UP");
                break;
            case MotionEvent.ACTION_CANCEL:
                System.out.println("FocusLinearLayout onTouchEvent MotionEvent.ACTION_CANCEL");
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public void onClick(View v) {
        System.out.println("onClick FocusLinearLayout");
    }
}
