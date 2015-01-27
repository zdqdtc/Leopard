/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      HttpCallBack.java
 * 类名:        HttpCallBack
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.action;

/**
 * 类名:		HttpCallBack
 * 描述:		网络回调接口
 * @author 	diqingzhu
 *
 */
public interface HttpCallBack<T> {
    public void httpStateCallBack(int code, T data);
}
