/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      LoginRequest.java
 * 类名:        LoginRequest
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.action;

import android.content.Context;

import com.android.volley.Request.Method;
import com.cat.external.http.BaseCall;
import com.cat.external.http.HttpCallBack;
import com.cat.external.http.annotation.Request;

/**
 * 类名:		LoginRequest
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
@Request(Method = Method.POST, Action = ActionConstant.ACTION_LOGIN, CacheEnable = true)
public class LoginCall extends BaseCall {

    public LoginCall(Context context, Object object, HttpCallBack callBack) {
        super(context, object, callBack);
        // TODO Auto-generated constructor stub
        
    }

    
   
}
