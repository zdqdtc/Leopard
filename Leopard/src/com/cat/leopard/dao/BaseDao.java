/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      BaseDao.java
 * 类名:        BaseDao
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.dao;

import com.cat.external.db.DatabaseHelper;

import android.content.Context;

/**
 * 类名:		BaseDao
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public abstract class BaseDao {
    protected Context        mContext;

    protected DatabaseHelper helper;

    public BaseDao(Context context) {
        mContext = context;
        helper = DatabaseHelper.getHelper(mContext);
    }
}
