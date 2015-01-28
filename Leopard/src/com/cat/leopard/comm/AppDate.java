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

import com.cat.external.log.Log;
import com.cat.external.util.FileUtil;

/**
 * 类名:		AppDate
 * 描述:	          全局内存缓存
 * @author 	diqingzhu
 */
public class AppDate extends Application {
    @SuppressWarnings("unused")
    private static final String  TAG   = "leopard";

    /**
     * 变量名:		DEBUG
     * 描述:			是否打开日志
     * 取值含义:		TODO
     */
    private static final boolean DEBUG = true;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        creatDebugModel(DEBUG);
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
            Log.w("sd card not exit!");
        }
    }

    /**
     * 描述:	 是否启动debug模式
     *
     */
    private void creatDebugModel(boolean isDebug) {
        Log.setEnabled(isDebug);
        Log.setLog2FileEnabled(isDebug);
        Log.setLog2ConsoleEnabled(isDebug);
    }
}
