package com.cat.external.app.update;

/**
 * 类名:		ParserAndGenerate
 * 描述:		TODO
 * @author 	diqingzhu
 *
 */
public interface ParserAndGenerate {
    /**
     * 将字符数据解析成Version对象
     * @param response
     * @return
     */
    Version parser(String response);

    String generate(RequestVersion requestVersion);
}