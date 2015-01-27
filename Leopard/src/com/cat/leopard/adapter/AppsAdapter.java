/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      AppsAdapter.java
 * 类名:        AppsAdapter
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.adapter;

import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.cat.leopard.R;
import com.cat.leopard.model.PackInfo;

/**
 * 类名:		AppsAdapter
 * 描述:		应用列表适配器
 * @author 	diqingzhu
 *
 */
public class AppsAdapter extends ArrayAdapter<PackInfo> {
    private LayoutInflater inflater;

    private ViewHolder     holder;

    private List<PackInfo> packInfos;

    public AppsAdapter(Context context, int textViewResourceId, List<PackInfo> packInfos) {
        super(context, textViewResourceId, packInfos);
        this.packInfos = packInfos;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        if (null != packInfos) {
            return packInfos.size();
        }
        return 0;
    }

    @Override
    public PackInfo getItem(int position) {
        return packInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SimpleDateFormat")
    @Override
    public View getView(final int position, View converView, final ViewGroup parent) {
        if (converView == null) {
            converView = inflater.inflate(R.layout.item_app, null);
            holder = new ViewHolder();
            holder.txtAppName = (TextView) converView.findViewById(R.id.txt_app_name);
            holder.txtAppVersion = (TextView) converView.findViewById(R.id.txt_app_version);
            holder.imgAppIcon = (ImageView) converView.findViewById(R.id.img_app_icon);
            holder.cbIsLock = (CheckBox) converView.findViewById(R.id.cb_is_lock);
            converView.setTag(holder);
        } else {
            holder = (ViewHolder) converView.getTag();
        }
        holder.txtAppName.setText(packInfos.get(position).getAppName());
        holder.txtAppVersion.setText(packInfos.get(position).getVersion());
        holder.imgAppIcon.setImageDrawable(packInfos.get(position).getAppIcon());
        return converView;
    }

    class ViewHolder {
        TextView  txtAppName;

        TextView  txtAppVersion;

        ImageView imgAppIcon;

        CheckBox  cbIsLock;
    }
}
