package com.konka.androidstudy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.konka.androidstudy.annotation.AnnotationActivity;
import com.konka.androidstudy.jump.ActivityOne;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        MyAdapter myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);

        List<HolderBean> list = new ArrayList<>();
        HolderBean activity_jump = new HolderBean("activity 跳转", ActivityOne.class);
        list.add(activity_jump);
        myAdapter.setData(list);

        Button button = new Button(this);

        OkHttpClient okHttpClient = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder().build();
        Call call = okHttpClient.newCall(request);
        try {
            call.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static class MyAdapter extends RecyclerView.Adapter<MyHolder> {

        private final List<HolderBean> mDataList = new ArrayList<>();

        public void setData(List<HolderBean> list) {
            mDataList.clear();
            mDataList.addAll(list);
            notifyDataSetChanged();
        }

        @NonNull
        @Override
        public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            TextView textView = new TextView(parent.getContext());
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 200);
            layoutParams.topMargin = 30;
            textView.setLayoutParams(layoutParams);
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(30);
            textView.setTextColor(Color.WHITE);
            textView.setBackgroundColor(Color.LTGRAY);
            return new MyHolder(textView);
        }

        @Override
        public void onBindViewHolder(@NonNull MyHolder holder, int position) {
            final int position2 = position;
            ((TextView) holder.itemView).setText(mDataList.get(position).getTitle());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    holder.itemView.getContext().startActivity(new Intent(holder.itemView.getContext(), mDataList.get(position2).getClazz()));
                }
            });
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }
    }

    public static class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            getLayoutPosition();
        }
    }

    public static class HolderBean {

        private final String title;
        private final Class<?> clazz;

        public HolderBean(String title, Class<?> clazz) {
            this.title = title;
            this.clazz = clazz;
        }

        public String getTitle() {
            return title;
        }

        public Class<?> getClazz() {
            return clazz;
        }
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        return super.dispatchKeyEvent(event);
    }
}