/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      CTBusFactory.java
 * 类名:        CTBusFactory
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.external.factory;

import com.squareup.otto.Bus;
import com.squareup.otto.ThreadEnforcer;

/**
 * 类名:		CTBusFactory
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public class CTBusFactory {
    private static final Bus BUS = new Bus(ThreadEnforcer.ANY);

    public static Bus getInstance() {
        return BUS;
    }
}
