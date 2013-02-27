package com.gengular.main;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class POIWrapper {

	final static Logger LOGGER = LoggerFactory.getLogger(POIWrapper.class);

	FileInputStream fis = null;
	HSSFWorkbook workbook = null;

	public POIWrapper(String pathToModelFile) {

		try {
			fis = new FileInputStream(pathToModelFile);
			workbook = new HSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

	public int getNumberOfSheets() {
		return workbook.getNumberOfSheets();
	}

	//TODO: complete with all methods required to pull data from the Excel.
}
