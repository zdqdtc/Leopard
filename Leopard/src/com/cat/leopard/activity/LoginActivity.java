package com.cat.leopard.activity;

import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.SparseArray;

import com.cat.leopard.R;
import com.cat.leopard.adapter.CardViewAdapter;
import com.cat.leopard.model.PackInfo;

public class LoginActivity extends BaseActivity {
    private RecyclerView          recyclerView;

    private SparseArray<PackInfo> infos = new SparseArray<PackInfo>();

    private CardViewAdapter       adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        PackInfo info = new PackInfo();
        for (int i = 0; i < 1000; i++) {
            infos.put(i, info);
        }
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.getRecycledViewPool().setMaxRecycledViews(0, 10);
        // 设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        // 创建Adapter，并指定数据集
        adapter = new CardViewAdapter(this, infos);
        // 设置Adapter
        recyclerView.setAdapter(adapter);
        //        // 设置默认动画
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        // FlipDownItemAnimator, SlideItemAnimator, FromTopItemAnimator
     
    }
}
