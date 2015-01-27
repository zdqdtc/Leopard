/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      HttpUtil.java
 * 类名:        HttpUtil
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.util;

import com.cat.leopard.action.BaseCall;
import com.cat.leopard.action.annotation.Request;

/**
 * 类名:		HttpUtil
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public class HttpUtil {
    private BaseCall request;

    public HttpUtil(BaseCall request) {
        this.request = request;
    }

    public void initRequest() {
        Class<?> cls = request.getClass();
        if (cls != null) {
            Request reqAnno = cls.getAnnotation(Request.class);
            request.setMethod(reqAnno.Method());
            request.setStrAction(reqAnno.Action());
        }
    }
}
