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
import com.cat.leopard.action.annotation.Request;
import com.cat.leopard.action.request.LoginRequest;

/**
 * 类名:		LoginRequest
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
@Request(Method = Method.POST, Action = ActionConstant.ACTION_LOGIN, CacheEnable = true)
public class LoginCall extends BaseCall<LoginRequest> {
    public LoginCall(Context context, LoginRequest object) {
        super(context, object);
    }
}
