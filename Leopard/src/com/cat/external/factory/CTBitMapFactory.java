/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      FinalBitMapFactory.java
 * 类名:        FinalBitMapFactory
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.external.factory;

import java.io.File;

import net.tsz.afinal.FinalBitmap;
import android.content.Context;

import com.cat.leopard.R;
import com.cat.leopard.comm.Constant;

/**
 * 类名:		FinalBitMapFactory
 * 描述:		图片加载工厂
 * @author 	diqingzhu
 *
 */
public class CTBitMapFactory {
    private static FinalBitmap  intance;

    private static final int    LOAD_THREAD_SIZE = 10;

    private static final int    DISK_CACHE_SIZE  = 1024 * 1024 * 1024;

    private static final String IMAGE_FILE       = "image/imageCache";

    public synchronized static FinalBitmap getIntance(Context context) {
        if (intance != null) {
            return intance;
        }
        intance = FinalBitmap.create(context);
        intance.configBitmapLoadThreadSize(LOAD_THREAD_SIZE);
        intance.configDiskCachePath(Constant.BASE_FILE + context.getPackageName() + File.separator
                + IMAGE_FILE + File.separator);
        intance.configRecycleImmediately(false);
        intance.configLoadingImage(R.drawable.progress_1);
        intance.configLoadfailImage(R.drawable.load_fail);
        intance.configMemoryCacheSize(DISK_CACHE_SIZE);
        intance.configDiskCacheSize(DISK_CACHE_SIZE);
        return intance;
    }
}
