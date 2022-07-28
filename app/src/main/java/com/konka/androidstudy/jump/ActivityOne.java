package com.konka.androidstudy.jump;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.konka.androidstudy.R;

/**
 * ActivityOne standard,ActivityTwo standard
 * I: ActivityOne onPause
 * I: ActivityTwo onCreate
 * I: ActivityTwo onStart
 * I: ActivityTwo onResume
 * I: ActivityOne onStop
 *
 * ActivityOne standard,ActivityTwo singleTop
 *
 * I: ActivityOne onPause
 * I: ActivityTwo onCreate
 * I: ActivityTwo onStart
 * I: ActivityTwo onResume
 * I: ActivityOne onStop
 *
 * 再次启动activity
 * I: ActivityTwo onPause
 * I: ActivityTwo onNewIntent
 * I: ActivityTwo onResume
 *
 * 如果不在栈顶的话会再次创建activity,并且执行生命周期
 *
 * ActivityOne singleTask,ActivityTwo singleTop
 * I/System.out: ActivityOne onPause
 * I/System.out: ActivityTwo onCreate
 * I/System.out: ActivityTwo onStart
 * I/System.out: ActivityTwo onResume
 * I/System.out: ActivityOne onStop
 *
 * 再次启动 ActivityOne 的生命周期
 * I/System.out: ActivityTwo onPause
 * I/System.out: ActivityOne onNewIntent
 * I/System.out: ActivityOne onRestart
 * I/System.out: ActivityOne onStart
 * I/System.out: ActivityOne onResume
 * I/System.out: ActivityTwo onStop
 * I/System.out: ActivityTwo onDestroy
 *
 * 按home键
 * I/System.out: ActivityOne onNewIntent
 * I/System.out: ActivityOne onRestart
 * I/System.out: ActivityOne onStart
 * I/System.out: ActivityOne onResume
 *
 * 如果 ActivityOne singleTask ,那么按home键回来上面的activity都会被移除
 *
 * Intent.FLAG_ACTIVITY_NEW_TASK  会添加进入新的栈
 * Intent.FLAG_ACTIVITY_CLEAR_TASK 清空任务栈
 *
 * 假设进程A启动了进程B的activity,那么进程B的activity在进程A的栈中,除非设置了new task
 *
 * TaskAffinity : 默认activity都在一个任务栈中(默认是包名),指定不同的名称可以创建不同的任务栈
 * 在singleTask 或 allowTaskReparenting 使用,其他情况没用
 *
 * allowTaskReparenting 允许activity迁移,从一个task移动到另一个task,移动task和TaskAffinity有关
 * 当allowTaskReparenting的值为“true”时，则表示Activity能从启动的Task移动到有着affinity的Task（当这个Task进入到前台时）
 *
 */
public class ActivityOne extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        System.out.println("ActivityOne onCreate");
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ActivityOne.this, ActivityTwo.class));
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("ActivityOne onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("ActivityOne onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("ActivityOne onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("ActivityOne onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("ActivityOne onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("ActivityOne onRestart");
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        System.out.println("ActivityOne onNewIntent");
    }

}