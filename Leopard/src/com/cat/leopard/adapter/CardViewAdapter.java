package com.cat.leopard.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.cat.leopard.R;
import com.cat.leopard.factory.CTBitMapFactory;
import com.cat.leopard.model.PackInfo;

@SuppressLint("InflateParams")
public class CardViewAdapter extends RecyclerView.Adapter<ViewHolder> {
    private SparseArray<PackInfo> packInfos;

    private LayoutInflater        inflater;

    private Context               context;

    public CardViewAdapter(Context context, SparseArray<PackInfo> packInfos) {
        inflater = LayoutInflater.from(context);
        this.packInfos = packInfos;
        this.context = context;
    }

    @Override
    public int getItemCount() {
        // TODO Auto-generated method stub
        return packInfos.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder arg0, int arg1) {
        CVHolderPic holderPic = (CVHolderPic) arg0;
        int a = arg1 % 2;
        holderPic.tvNum.setText(arg1 + "");
        switch (a) {
        case 0:
            CTBitMapFactory.getIntance(context).display(holderPic.ivAppIcon, "http://img2.imgtn.bdimg.com/it/u=503737366,2010945706&fm=90&gp=0.jpg");
            holderPic.itemView.setBackgroundResource(R.color.green);
            break;
        case 1:
            CTBitMapFactory.getIntance(context).display(holderPic.ivAppIcon, "http://img2.imgtn.bdimg.com/it/u=2332213268,3725109442&fm=21&gp=0.jpg");
            holderPic.itemView.setBackgroundResource(R.color.blue);
            break;
        default:
            break;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup arg0, int arg1) {
        View view = inflater.inflate(R.layout.item_cv_pic, null);
        ViewHolder holder = new CVHolderPic(view);
        return holder;
    }

    public static class CVHolderPic extends ViewHolder {
        private ImageView ivAppIcon;

        private TextView  tvNum;

        public CVHolderPic(View itemView) {
            super(itemView);
            ivAppIcon = (ImageView) itemView.findViewById(R.id.imageView1);
            tvNum = (TextView) itemView.findViewById(R.id.tv_num);
        }
    }

    public static class CVHolderText extends ViewHolder {
        public CVHolderText(View itemView) {
            super(itemView);
            // TODO Auto-generated constructor stub
        }
    }

    public static class CVHolderPicAndTxr extends ViewHolder {
        public CVHolderPicAndTxr(View itemView) {
            super(itemView);
            // TODO Auto-generated constructor stub
        }
    }
}
