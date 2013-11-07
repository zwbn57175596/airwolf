package com.zhaowei.poi.first;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			File file = new File("/GitHub/airwolf/ApachePOI/src/filesapi_citycode.xlsx");
			InputStream inp = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
