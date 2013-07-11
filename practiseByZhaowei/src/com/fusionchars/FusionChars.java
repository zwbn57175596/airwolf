package com.fusionchars;

import java.util.HashMap;


public abstract class FusionChars<T> {
	
	/////////////////////FunsionChars method
	/**
	 * 获取横坐标的ID
	 * @return
	 */
	public abstract String getModelId(T t);
	
	/**
	 * 获取横坐标的显示名称
	 * @return
	 */
	public abstract String getModelNm(T t);
	
	/**
	 * 设置dataSetName
	 * @return
	 */
	public abstract String getDatasetName(T t);
	
	/**
	 * 获取数据值
	 * @return
	 */
	public abstract String getValue(T t);
	
	/**
	 * 添加javascript连接
	 * @param t
	 * @return
	 */
	public abstract String getJavascriptLink(T t);
	
	////////////////////////////////////////////////////////
	
	
	
	
	
	private HashMap<String, String> chars;
	
	// TODO DESING
	// private T trendlines;
	// private T styles;
	
	/**
	 * 返回XML格式的FusionChars数据流
	 * @return
	 */
	public abstract String getXml();

	/**
	 * 返回JSON格式的FusionChars数据流
	 * @return
	 */
	@Deprecated
	public abstract String getJson();

	
	/**
	 * @return the chars
	 */
	protected HashMap<String, String> getChars() {
		return chars;
	}

	/**
	 * @param chars the chars to set
	 */
	public void setChars(HashMap<String, String> chars) {
		this.chars = chars;
	}
}
