/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      BaseRequest.java
 * 类名:        BaseRequest
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.external.http;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;

import com.alibaba.fastjson.JSON;
import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.cat.leopard.action.ActionConstant;

/**
 * 类名:		BaseRequest
 * 描述:		TODO
 * @author 	diqingzhu
 * @param <T>
 *
 */
public class BaseCall {
    private String       strAction   = "";

    private JSONObject   requestBody;

    private Context      context;

    private int          method      = Method.POST;

    private boolean      isFileCache = false;

    private HttpCallBack mCallBack;

    public BaseCall(Context context, Object object, HttpCallBack callBack) {
        this.context = context;
        HttpUtil httpUtil = new HttpUtil(this);
        httpUtil.initRequest();
        setRequestBody(object);
        mCallBack = callBack;
    }

    public void request() {
        JsonObjectRequest request = new JsonObjectRequest(getMethod(), strAction, requestBody, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                mCallBack.response(0, response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {}
        });
        request.setShouldCache(isFileCache);
        CTVolleyHttpFactory.getIntance(context).add(request);
    }

    public void setStrAction(String strAction) {
        this.strAction = ActionConstant.BASE_URL + strAction;
    }

    public void setRequestBody(Object object) {
        try {
            this.requestBody = new JSONObject(JSON.toJSONString(object).toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public int getMethod() {
        return method;
    }

    public void setMethod(int method) {
        this.method = method;
    }

    public boolean isFileCache() {
        return isFileCache;
    }

    public void setFileCache(boolean isFileCache) {
        this.isFileCache = isFileCache;
    }
}
