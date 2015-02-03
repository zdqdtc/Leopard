/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      HttpCallBack.java
 * 类名:        HttpCallBack
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.external.http;

import org.json.JSONObject;

/**
 * 类名:		HttpCallBack
 * 描述:		网络回调接口
 * @author 	diqingzhu
 *
 */
public interface HttpCallBack {
    
    public void response(int code,JSONObject json);
    
}
