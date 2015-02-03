package com.cat.leopard.model;

import com.cat.external.http.BaseCall;

import android.content.Context;

public class BaseModel {
    protected Context mContext;

    public BaseModel(Context context) {
        mContext = context;
    }
    
    protected void request(BaseCall call)
    {
        call.request();
    }
}
