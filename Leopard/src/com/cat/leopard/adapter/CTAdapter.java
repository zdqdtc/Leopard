/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      CommAdapter.java
 * 类名:        CommAdapter
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 类名:		CommAdapter
 * 描述:		base适配器
 * @author 	diqingzhu
 *
 */
public abstract class CTAdapter extends BaseAdapter {
    protected List<?>      objects;

    protected Context      context;

    private LayoutInflater inflater;

    protected ViewHolder   viewHolder;

    private int            resource;

    public CTAdapter(Context context, List<?> objects, int resource) {
        this.context = context;
        this.objects = objects;
        this.resource = resource;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(resource, null);          
            initView(convertView);
            convertView.setTag(viewHolder);
        } else {     
            viewHolder = (ViewHolder) convertView.getTag();
        }    
        initViewDate(position, viewHolder);
        return convertView;
    }

    public static class ViewHolder {}

    /**
     * 描述:		初始化view
     *
     * @param convertView
     */
    abstract void initView(View convertView);

    /**
     * 描述:		设置数据
     *
     * @param position
     * @param convertView
     */
    abstract void initViewDate(int position, ViewHolder viewHolder);
}