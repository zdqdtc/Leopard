package com.cat.external.app.update;




/**
 * 将服务端响应解析数据为Version对象
 * 
 * @author ilovedeals
 * 
 */
public interface Parser {
	/**
	 * 将字符数据解析成Version对象
	 * @param response
	 * @return
	 */
	Version parser(String response);
	
	String generate(RequestVersion requestVersion);
}