package com.cat.leopard.model;

import org.json.JSONObject;

import android.content.Context;

import com.cat.external.http.HttpCallBack;
import com.cat.leopard.action.LoginCall;
import com.cat.leopard.action.request.LoginRequest;
import com.cat.leopard.action.response.LoginResponse;

public class UserModel extends BaseModel {
   
    
    
    public UserModel(Context context) {
        super(context);
        // TODO Auto-generated constructor stub
    }

    public void login(LoginRequest request, LoginResponse response) {
        LoginCall loginCall = new LoginCall(mContext, request, new HttpCallBack() {
            @Override
            public void response(int code, JSONObject json) {
                // TODO Auto-generated method stub
            }
        });
        loginCall.request();
    }
}
