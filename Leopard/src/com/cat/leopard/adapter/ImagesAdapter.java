/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      ImagesAdapter.java
 * 类名:        ImagesAdapter
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.adapter;

import java.util.ArrayList;
import java.util.List;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.cat.leopard.R;
import com.cat.leopard.factory.CTBitMapFactory;
import com.cat.leopard.model.Image;

/**
 * 类名:		ImagesAdapter
 * 描述:		DemoAdapter
 * @author 	diqingzhu
 *
 */
public class ImagesAdapter extends CTAdapter {
    private Holder      holder;

    private List<Image> images = new ArrayList<Image>();

    public ImagesAdapter(Context context, List<Image> objects, int layout) {
        super(context, objects, layout);
        images = objects;
    }

    @Override
    void initView(View convertView) {
        holder = new Holder();
        viewHolder = holder;
        holder.txtSize = (TextView) convertView.findViewById(R.id.txt_size);
        holder.ivImage = (ImageView) convertView.findViewById(R.id.iv_image);
    }

    @Override
    void initViewDate(int position, ViewHolder viewHolder) {
        Holder newHolder = (Holder) viewHolder;
        newHolder.txtSize.setText(images.get(position).getSize() + "kb");
        CTBitMapFactory.getIntance(context).display(newHolder.ivImage, images.get(position).getUrl());
    }

    static class Holder extends CTAdapter.ViewHolder {
        TextView  txtSize;

        ImageView ivImage;
    }
}
