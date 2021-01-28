package com.me.mesite.common.utils;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 2017-04-25
 */
public class AppBaseResult<T> implements Serializable {

	private int code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
	private String message = "";
	private String data = "";
	private String version = "1.0";
	private String mobile = "";

	private final static int TOKENFAIL = 1000;
	private final static String KEY = "czx12345";


	public static AppBaseResult success(String msg){
		AppBaseResult appBaseResult = new AppBaseResult();
		appBaseResult.setCode(HttpStatus.SC_OK);
		appBaseResult.setMessage(msg);
		return appBaseResult;
	}

	public static AppBaseResult success(){
		AppBaseResult appBaseResult = new AppBaseResult();
		appBaseResult.setCode(HttpStatus.SC_OK);
		appBaseResult.setMessage("请求成功");
		return appBaseResult;
	}

	public static AppBaseResult error(String msg){
		AppBaseResult appBaseResult = new AppBaseResult();
		appBaseResult.setCode(HttpStatus.SC_INTERNAL_SERVER_ERROR);
		appBaseResult.setMessage(msg);
		return appBaseResult;
	}

	public static AppBaseResult error(int code,String msg){
		AppBaseResult appBaseResult = new AppBaseResult();
		appBaseResult.setCode(code);
		appBaseResult.setMessage(msg);
		return appBaseResult;
	}

	public static AppBaseResult error() {
		return error( "未知异常，请联系管理员");
	}

	
	public int getCode() {
		return code;
	}
	public AppBaseResult setCode(int status) {
		this.code = status;
		return this;
	}
	public String getMessage() {
		return message;
	}
	public AppBaseResult setMessage(String message) {
		this.message = message;
		return this;
	}
	public String getData() {
		return  this.data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public HashMap<String,Object> decryptData(String data) {
		String mData = null;
		if(!Tools.isEmpty(data)){
			try {
				mData = CDESCrypt.decryptString(data, KEY);
				mData=data;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return new Gson().fromJson(mData,new TypeToken<HashMap<String,Object>>() {}.getType());
	}

	public String decryptData() {
		String mData = null;
		if(!Tools.isEmpty(this.data)){
			try {
//				mData = CDESCrypt.decryptString(this.data, KEY);
				mData=this.data;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mData;
	}
	
	public AppBaseResult setEncryptData(T t) {
		String mData = new Gson().toJson(t);
		try {
			if(!Tools.isEmpty(mData)){
//				this.data = CDESCrypt.encryptString(mData, KEY);
				this.data=mData;
			}else{
				this.data = mData;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this;
	}

	public String getVersion() {
		return version;
	}
	public AppBaseResult setVersion(String version) {
		this.version = version;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public AppBaseResult setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	@Override
	public String toString() {
		return "{" +
				"code='" + code + '\'' +
				", message='" + message + '\'' +
				", data='" + data + '\'' +
				", version='" + version + '\'' +
				", mobile='" + mobile + '\'' +
				'}';
	}
}