/*
 * 项目名:      LEOPARD.CAT
 * 文件名:      PackInfo.java
 * 类名:        PackInfo
 *
 * 版权声明:
 *      
 *     Copyright © 1999-2014, leopard, All Rights Reserved 
 */
package com.cat.leopard.model;

import android.graphics.drawable.Drawable;

/**
 * 类名:		PackInfo
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public class PackInfo {
    private String   packName="";

    private String   version="";

    private Drawable appIcon;

    private String   appName="";
    
    private boolean userApp=true;

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public boolean isUserApp() {
        return userApp;
    }

    public void setUserApp(boolean userApp) {
        this.userApp = userApp;
    }
}
