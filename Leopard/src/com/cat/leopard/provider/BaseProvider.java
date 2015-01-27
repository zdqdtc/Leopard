/*
 * 项目名:      农夫山泉桶装水订水系统
 * 文件名:      BaseProvider.java
 * 类名:        BaseProvider
 *
 * 版权声明:
 *      本系统的所有内容，包括源码、页面设计，文字、图像以及其他任何信息，
 *      如未经特殊说明，其版权均属农夫山泉股份有限公司所有。
 *
 *      Copyright (c) 2013 农夫山泉股份有限公司
 *      版权所有
 */
package com.cat.leopard.provider;

import java.io.File;
import java.io.IOException;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.cat.leopard.comm.AppDate;
import com.cat.leopard.util.CacheManager;
import com.nongfu.customer.cache.DiskCache;
import com.nongfu.customer.cache.PutCallback;

/**
 * 类名:		BaseProvider
 * 描述:		TODO
 * @author 	diqingzhu
 * @param <E>
 *
 */
public abstract class BaseProvider {
    protected Context           context;

    private static final String CACHE_DIRECTORY = Environment.getExternalStorageDirectory() + File.separator + "Customer" + File.separator
                                                        + "DiskCache";

    private static final int    APP_VERSION     = 1;

    private static final int    CACHE_SIZE      = 20 * 1024 * 1024;

    public static DiskCache     diskCache;

    private String              key;

    private Object              object;

    private Class<?>            objectClass;

    public AppDate              appl;

    public BaseProvider(Context context, Object object) {
        this.context = context;
        this.object = object;
        appl = (AppDate) context.getApplicationContext();
        try {
            diskCache = new DiskCache(new File(CACHE_DIRECTORY), APP_VERSION, CACHE_SIZE);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void putObject() {
        CacheManager.getInstance(diskCache).putAsync(key, object, new PutCallback() {
            @Override
            public void onSuccess() {
                Log.e("aaa", "success");
            }

            @Override
            public void onFailure(Exception e) {
                // TODO Auto-generated method stub
            }
        });
    }

    public void getObject() {
        Object(CacheManager.getInstance(diskCache).get(key, objectClass, objectClass));
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setObjectClass(Class<?> objectClass) {
        this.objectClass = objectClass;
    }

    public static void clearn() {
        try {
            if (null != diskCache)
                CacheManager.getInstance(diskCache).clear();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    abstract void Object(Object object);
}
