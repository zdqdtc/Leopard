/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      BaseFragment.java
 * 类名:        BaseFragment
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 类名:		BaseFragment
 * 描述:		基础类
 * @author 	diqingzhu
 *
 */
public abstract class BaseFragment extends Fragment {
    protected View    view;

    protected Context context;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        context = this.getActivity();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract void initView(View view);

    protected abstract void initData();
}
