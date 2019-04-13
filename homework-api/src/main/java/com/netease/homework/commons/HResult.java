package com.netease.homework.commons;

import java.io.Serializable;

public class HResult implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2524657107819605324L;
	// 响应业务状态
    private Integer code;
    // 响应消息
    private String result;
    
    public HResult(Integer code,String result) {
		this.setCode(code);
		this.setResult(result);
	}
    
    public static HResult ok(){
    	return new HResult(200, null);
    }
    
    public static HResult ok(String msg){
    	return new HResult(200, msg);
    }
    
    public static HResult build(Integer code,String msg){
    	return new HResult(code, msg);
    }

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
