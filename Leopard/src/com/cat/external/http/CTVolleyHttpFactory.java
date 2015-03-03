/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      CTVolleyHttpFactory.java
 * 类名:        CTVolleyHttpFactory
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.external.http;

import java.io.File;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HttpClientStack;
import com.android.volley.toolbox.HttpStack;
import com.android.volley.toolbox.HurlStack;

/**
 * 类名:		CTVolleyHttpFactory
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public class CTVolleyHttpFactory {
    
    private static RequestQueue queue;

    private static HttpStack    stack;

    private static final String DEFAULT_CACHE_DIR = "leopard";

    private static final int    POOL_SIZE         = 8;

    private CTVolleyHttpFactory() {}

    public static synchronized RequestQueue getIntance(Context context) {
        if (null == queue) {
            File cacheDir = new File(context.getCacheDir(), DEFAULT_CACHE_DIR);
            String userAgent = "volley/0";
            try {
                String packageName = context.getPackageName();
                PackageInfo info = context.getPackageManager().getPackageInfo(packageName, 0);
                userAgent = packageName + "/" + info.versionCode;
            } catch (NameNotFoundException e) {}
            if (stack == null) {
                if (Build.VERSION.SDK_INT >= 9) {
                    stack = new HurlStack();
                } else {
                    stack = new HttpClientStack(AndroidHttpClient.newInstance(userAgent));
                }
            }
            Network network = new BasicNetwork(stack);
            queue = new RequestQueue(new DiskBasedCache(cacheDir), network, POOL_SIZE);
            queue.start();
        }
        return queue;
    }
}
