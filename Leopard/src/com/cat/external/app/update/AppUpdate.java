package com.cat.external.app.update;

import android.content.Context;

import com.cat.leopard.action.BaseCall;
import com.cat.leopard.action.request.BaseRequest;

/**
 * 自动更新服务的操作接口
 * 
 * @author ilovedeals
 * 
 */
public interface AppUpdate {
    /**
     * 设置自定义显示新版本信息接口
     * 
     * @param displayer
     */
    void setCustomDisplayer(Displayer displayer);

    /**
     * 从指定URL检查新版本，并指定响应数据解析器。
     * 如果URL返回的版本码大于当前App的版本码，若没有通过setCustomVersionShowing指定版本提示的
     * 显示方式，默认弹出一个系统级窗口（需要指定 <uses-permission android:name="android.permission.SYSTEM_ALERT_WINDOW" /> 权限）。
     * method post or get
     * @param <T>
     * 
     * @param url
     * @param parser
     * 
     */
    void checkLatestVersion(String url, Parser parser, RequestVersion version);

    /**
     * 从指定版本中下载并安装APK文件
     * 
     * @param url
     */
    void downloadAndInstall(Version targetVersion);

    /**
     * 下载当前已经取得的版本
     */
    void downloadAndInstallCurrent();
}
