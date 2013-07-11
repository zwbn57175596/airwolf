package com.fusionchars;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

@SuppressWarnings("rawtypes")
public abstract class MultiSeriesChars<T> extends FusionChars {

	/** category attributes */
	private HashMap<String, Object> categoriesMap;
	/** datasetsList */
	private List<HashMap<String, Object>> dataSetsList;

	public MultiSeriesChars(List<List<T>> inputDataList) throws SecurityException, IllegalArgumentException,
			NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		// define the queryType
		// initial default attr value
		// charsMap.put("formatNumberScale", "0");// 不进行格式化
		// charsMap.put("shownames", "1");
		// charsMap.put("baseFont", "宋体");
		// charsMap.put("baseFontSize", "12");
		// charsMap.put("showvalues", "0");
		// charsMap.put("decimals", "2");
		// charsMap.put("imageSave", "1");
		// charsMap.put("imageSaveURL", "FusionCharts/FusionChartsSave.jsp");

		/* setJsLink();// 设置JS参数 */
		// this.methodName = methodName;
		// this.params = params;

		initData(inputDataList); // Construct the chars body

	}

	/**
	 * Construct the chars body
	 * 
	 * @throws NoSuchMethodException
	 * @throws SecurityException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 * @throws IllegalArgumentException
	 */
	@SuppressWarnings({ "unchecked" })
	private void initData(List<List<T>> inputDataList) throws SecurityException, NoSuchMethodException,
			IllegalArgumentException, IllegalAccessException, InvocationTargetException {

		List<HashMap<String, T>> dataList = new ArrayList<HashMap<String, T>>();
		for (List<T> list : inputDataList) {
			HashMap<String, T> map = new HashMap<String, T>();
			for (T t : list) {
				map.put(getModelId(t), t);
			}
			dataList.add(map);
		}

		// category列表
		List<String> categoryList = new ArrayList<String>();
		// 多sets列表(维度）
		List<List<HashMap<String, String>>> setsList = new ArrayList<List<HashMap<String, String>>>();
		for (int i = 0; i < inputDataList.size(); i++) {
			setsList.add(new ArrayList<HashMap<String, String>>());
		}

		HashMap<String, String> set = null;

		Set<String> keySet = dataList.get(0).keySet(); // funsionChar横坐标
		// for test scriptLink has been set or not
		if (getJavascriptLink(null) == null || "".equals(getJavascriptLink(null)))
			//no link
			for (String keys : keySet) { 
				// category列表
				categoryList.add(getModelNm(dataList.get(0).get(keys)));

				for (int i = 0; i < inputDataList.size(); i++) {
					set = new HashMap<String, String>();
					set.put("value", getValue(dataList.get(i).get(keys)));
					setsList.get(i).add(set);
				}
			}
		else
			// has link
			for (String keys : keySet) {
				// category列表
				categoryList.add(getModelNm(dataList.get(0).get(keys)));
				for (int i = 0; i < inputDataList.size(); i++) {
					set = new HashMap<String, String>();
					set.put("value", getValue(dataList.get(i).get(keys)));
					set.put("link", getJavascriptLink(dataList.get(i).get(keys)));
					setsList.get(i).add(set);
				}
			}

		// 设置dataSetLists
		// TODO 抽象DATASET COLOR
		for (int i = 0; i < inputDataList.size(); i++) {
			HashMap<String, Object> dataSet = new HashMap<String, Object>();
			dataSet.put("seriesName", getDatasetName(dataList.get(i).get(keySet.iterator().next())));
			// dataSet.put("color", OwnBusiServiceBase.DEFAULT_COLOR_LIST[i]);
			// // use fusionChars color
			// // use
			// default
			// color
			dataSet.put("showValues", "0");
			dataSet.put("setList", setsList.get(i));
			dataSetsList.add(dataSet);
		}

		// 设置categories
		categoriesMap.put("categoryList", categoryList);
	}

	@SuppressWarnings({ "unchecked" })
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

		// 生成数据节点categories
		Element categories = chart.addElement("categories");
		// 迭代category属性
		List<String> categoryList = (List<String>) categoriesMap.get("categoryList");
		for (int i = 0; i < categoryList.size(); i++) {
			Element categoriestmp = categories.addElement("category");
			categoriestmp.addAttribute("label", categoryList.get(i));
		}
		// 删掉categoryList
		categoriesMap.remove("categoryList");
		// 迭代categorie属性
		Set<String> categoryKeys = categoriesMap.keySet();
		for (String string : categoryKeys) {
			categories.addAttribute(string, (String) categoriesMap.get(string));
		}

		for (HashMap<String, Object> dataSet : dataSetsList) { // 遍历所有的datasets
			Element dataSetElement = chart.addElement("dataset"); // 在chart的节点加增加一个dataset节点

			// 处理这一个dataset中的所有set
			List<HashMap<String, String>> setList = (List<HashMap<String, String>>) dataSet.get("setList");
			for (HashMap<String, String> set : setList) {
				Element setElement = dataSetElement.addElement("set"); // 在dataset节点下加一个set节点
				Set<String> keySet = set.keySet();
				// 设置set节点的属性
				for (String string : keySet) {
					setElement.addAttribute(string, set.get(string));
				}
			}// 增加完这个dataset下所有的set

			dataSet.remove("setList"); // 删除set，为遍历dataset的属性做准备
			// 设置set节点的属性
			Set<String> dataKeySet = dataSet.keySet();
			for (String string : dataKeySet) {
				dataSetElement.addAttribute(string, (String) dataSet.get(string));
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
	 * @return the dataSetsList
	 */
	protected List<HashMap<String, Object>> getDataSetsList() {
		return dataSetsList;
	}

	/**
	 * @param dataSetsList
	 *            the dataSetsList to set
	 */
	public void setDataSetsList(List<HashMap<String, Object>> dataSetsList) {
		this.dataSetsList = dataSetsList;
	}

	/**
	 * @return the categoriesMap
	 */
	protected HashMap<String, Object> getCategoriesMap() {
		return categoriesMap;
	}

	/**
	 * @param categoriesMap
	 *            the categoriesMap to set
	 */
	public void setCategoriesMap(HashMap<String, Object> categoriesMap) {
		this.categoriesMap = categoriesMap;
	}

}
