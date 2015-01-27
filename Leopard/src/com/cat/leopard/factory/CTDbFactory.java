/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      CTDbFactory.java
 * 类名:        CTDbFactory
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.factory;

import net.tsz.afinal.FinalDb;
import net.tsz.afinal.FinalDb.DaoConfig;
import android.content.Context;

/**
 * 类名:		CTDbFactory
 * 描述:		数据库操作工厂类
 * @author 	diqingzhu
 *
 */
public class CTDbFactory {
    private static FinalDb       intance;

    private static DaoConfig     config;

    private final static String  DB_NAME    = "";

    private final static int     DB_VERSION = 1;

    private final static boolean IS_DEBUG   = true;

    public synchronized static FinalDb getIntance(Context context) {
        if (intance != null) {
            return intance;
        }
        config = new DaoConfig();
        config.setDbVersion(DB_VERSION);
        config.setDbName(DB_NAME);
        config.setDebug(IS_DEBUG);
        intance = FinalDb.create(config);
        return intance;
    }
}
