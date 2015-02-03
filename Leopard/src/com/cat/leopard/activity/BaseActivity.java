/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      BaseActivity.java
 * 类名:        BaseActivity
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 *
 *      
 *
 */
package com.cat.leopard.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.cat.external.util.ActivityTaskManager;
import com.cat.leopard.widget.dialog.CustomProgressDialog;

/**
 * 类名:		BaseActivity
 * 描述:		基础activity类
 * @author 	diqingzhu
 */
@SuppressLint("NewApi")
public class BaseActivity extends FragmentActivity  {
    private CustomProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle arg0) {
        // TODO Auto-generated method stub
        super.onCreate(arg0);
        ActivityTaskManager.getInstance().putActivity(this.getClass().getName(), this);
    
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityTaskManager.getInstance().removeActivity(this.getClass().getName());
    }

    /**
     * 描述:	界面跳转
     *
     * @param cls
     */
    protected void skipToActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        this.finish();
    }

    /**
     * 描述:	 显示进度
     *
     */
    protected void showProgressDialog() {
        if (progressDialog == null) {
            progressDialog = CustomProgressDialog.createDialog(this);
            progressDialog.setMessage("正在加载中...");
        }
        progressDialog.show();
    }

    /**
     * 描述:	关闭进度
     *
     */
    protected void closeProgressDialog() {
        if (progressDialog != null) {
            progressDialog.dismiss();
            progressDialog = null;
        }
    }
  
}
