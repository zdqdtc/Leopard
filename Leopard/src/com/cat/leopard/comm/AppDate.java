/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      AppDate.java
 * 类名:        AppDate
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.comm;

import android.app.Application;
import android.util.Log;

import com.cat.external.util.FileUtil;

/**
 * 类名:		AppDate
 * 描述:	          全局内存缓存
 * @author 	diqingzhu
 */
public class AppDate extends Application {
    
    private  static final String TAG="leopard";
    
   
    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        creatAppFile();

    }

    /**
     * 描述:	 应用文件创建
     *
     */
    private void creatAppFile() {
        if (FileUtil.isSdcardAvailable()) {
            FileUtil.createFile(this.getPackageName());
        } else {
            Log.e(TAG, "Sd卡不可用");
        }
    }
}
