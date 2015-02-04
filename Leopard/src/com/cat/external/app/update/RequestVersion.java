package com.cat.external.app.update;

/**
 * 类名:		RequestVersion
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public class RequestVersion {
    /**
     * 版本号 e.g: 13
     */
    public int    code;

    /**
     * 版本名 e.g: 1.0.9
     */
    public String name;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
