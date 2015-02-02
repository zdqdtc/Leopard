package com.cat.external.app.update;

public class Version {
    /**
     * 版本号 e.g: 13
     */
    public int    code;

    /**
     * 版本名 e.g: 1.0.9
     */
    public String name;

    /**
     * 此版本特性 e.g: Fixed bugs
     */
    public String feature;

    /**
     * 此版本APK下载地址
     */
    public String targetUrl;

    public Version(int code, String name, String feature, String targetUrl) {
        this.code = code;
        this.name = name;
        this.feature = feature;
        this.targetUrl = targetUrl;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public void setTargetUrl(String targetUrl) {
        this.targetUrl = targetUrl;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getFeature() {
        return feature;
    }

    public String getTargetUrl() {
        return targetUrl;
    }
}
