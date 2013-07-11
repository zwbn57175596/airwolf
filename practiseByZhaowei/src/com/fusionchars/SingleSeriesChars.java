package com.fusionchars;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class SingleSeriesChars extends FusionChars {
	
	private List<HashMap<String, String>> setsList;

	@SuppressWarnings("rawtypes")
	@Override
	public String getXml() {
		Document document = DocumentHelper.createDocument();
		// 生成chart根节点
		Element chart = document.addElement("chart");
		// 迭代chart属性
		for (Iterator it = getChars().entrySet().iterator(); it.hasNext();) {
			Map.Entry e = (Map.Entry) it.next();
			chart.addAttribute(e.getKey().toString(), e.getValue().toString());
		}
		
		// 生成char节点下的sets
		for (HashMap<String, String> temp : setsList) {
			Element set = chart.addElement("set");
			for (Iterator it = temp.entrySet().iterator(); it.hasNext();) {
				Map.Entry e = (Map.Entry) it.next();
				set.addAttribute(String.valueOf(e.getKey()), String.valueOf(e.getValue()));
			}
		}
		return document.asXML();
	}

	@Override
	public String getJson() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @return the setsList
	 */
	protected List<HashMap<String, String>> getSetsList() {
		return setsList;
	}

	/**
	 * @param setsList the setsList to set
	 */
	public void setSetsList(List<HashMap<String, String>> setsList) {
		this.setsList = setsList;
	}

	@Override
	public String getModelId(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getModelNm(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getDatasetName(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValue(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJavascriptLink(Object t) {
		// TODO Auto-generated method stub
		return null;
	}

}
