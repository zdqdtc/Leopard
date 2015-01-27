package com.cat.leopard.action.response;

/**
 * 类名:		BaseResponse
 * 描述:		基础返回类
 * @author 	diqingzhu
 *
 * @param <T>
 */
public class BaseResponse<T> {
    /**
     * 变量名:		erroCode
     * 描述:			TODO
     * 取值含义:		错误信息码
     */
    private int    erroCode;

    /**
     * 变量名:		erroMsg
     * 描述:			TODO
     * 取值含义:		错误信息
     */
    private String erroMsg;

    /**
     * 变量名:		data
     * 描述:			TODO
     * 取值含义:		返回的数据集合
     */
    private T      data;

    public int getErroCode() {
        return erroCode;
    }

    public void setErroCode(int erroCode) {
        this.erroCode = erroCode;
    }

    public String getErroMsg() {
        return erroMsg;
    }

    public void setErroMsg(String erroMsg) {
        this.erroMsg = erroMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
