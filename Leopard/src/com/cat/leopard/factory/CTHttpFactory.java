/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      FinalHttpFactory.java
 * 类名:        FinalHttpFactory
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.factory;

import net.tsz.afinal.FinalHttp;

import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.protocol.HTTP;

/**
 * 类名:		FinalHttpFactory
 * 描述:		http工厂类
 * @author 	diqingzhu
 *
 */
public class CTHttpFactory {
    
    private static FinalHttp intance;

    public synchronized static FinalHttp getIntance() {
        if (intance != null) {
            return intance;
        }    
        
        intance = new FinalHttp();
        intance.configTimeout(5000);
        intance.configRequestExecutionRetryCount(1);
        intance.configCharset(HTTP.UTF_8);
        intance.configSSLSocketFactory(SSLSocketFactory.getSocketFactory());
        
        return intance;
    }
}
