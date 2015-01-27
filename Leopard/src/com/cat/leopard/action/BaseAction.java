/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      BaseAction.java
 * 类名:        BaseAction
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.action;

import java.io.UnsupportedEncodingException;

import net.tsz.afinal.http.AjaxCallBack;
import net.tsz.afinal.http.AjaxParams;

import org.apache.http.HttpEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HTTP;

import com.alibaba.fastjson.JSON;
import com.cat.leopard.factory.CTHttpFactory;

import android.content.Context;

/**
 * 类名:		BaseAction
 * 描述:		基础请求类
 * @author 	diqingzhu
 *
 */
public abstract class BaseAction {
    private HttpCallBack<?> httpCallBack;

    private String       strAction;

    private String       strContent = HTTP.DEFAULT_CONTENT_TYPE;

    private HttpEntity   entity;

    private Object       object;

    private AjaxParams   ajaxParams;

    public BaseAction(AjaxParams ajaxParams, Context context) {
        this.ajaxParams = ajaxParams;
    }

    public BaseAction(Object object, Context context) {
        this.object = object;
        setEntity();
    }


    public void get() {
        CTHttpFactory.getIntance().get(strAction, ajaxParams, new AjaxCallBack<Object>() {
            @Override
            public void onSuccess(Object t) {
                super.onSuccess(t);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

    public void post() {
        CTHttpFactory.getIntance().post(strAction, entity, strContent, new AjaxCallBack<Object>() {
            @Override
            public void onSuccess(Object t) {
                super.onSuccess(t);
            }

            @Override
            public void onFailure(Throwable t, int errorNo, String strMsg) {
                super.onFailure(t, errorNo, strMsg);
            }
        });
    }

    public void downLoad() {}

    abstract void parseJSON(String strJson);

    public HttpCallBack<?> getHttpCallBack() {
        return httpCallBack;
    }

    public void setHttpCallBack(HttpCallBack<?> httpCallBack) {
        this.httpCallBack = httpCallBack;
    }

    public String getStrAction() {
        return strAction;
    }

    public void setStrAction(String strAction) {
        this.strAction = ActionConstant.BASE_URL + strAction;
    }

    public String getStrContent() {
        return strContent;
    }

    public void setStrContent(String strContent) {
        this.strContent = strContent;
    }

    public HttpEntity getEntity() {
        return entity;
    }

    public void setEntity() {
        String json = JSON.toJSONString(object);
        try {
            this.entity = new StringEntity(json, HTTP.UTF_8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
