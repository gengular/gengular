package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gengular.main.POIWrapper;

public class POIWrapperTest {

	final static Logger LOGGER = LoggerFactory.getLogger(POIWrapperTest.class);

	String pathToModelFile = "src/test/resources/models/unittest.xls";

	@Test
	public void testPOIWrapper() {

		POIWrapper poi = new POIWrapper(pathToModelFile);
		assertNotNull(poi);

	}

	@Test
	public void testGetNumberOfSheets() {

		FileInputStream fis = null;
		HSSFWorkbook workbook = null;

		try {
			fis = new FileInputStream(pathToModelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int numberOfSheets = workbook.getNumberOfSheets();
		assertEquals(3, numberOfSheets);
	}

	@Test
	public void testLoopOverFile() {

		FileInputStream fis = null;
		HSSFWorkbook workbook = null;
		HSSFSheet sheet = null;
		int numberOfSheets = 0;

		try {
			fis = new FileInputStream(pathToModelFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			workbook = new HSSFWorkbook(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		numberOfSheets = workbook.getNumberOfSheets();
		for (int i = 0; i < numberOfSheets; i++) {
			sheet = workbook.getSheetAt(i);
			LOGGER.info("sheet: " + sheet.getSheetName());
			for (Row row : sheet) {
				LOGGER.info("row: " + row.getRowNum());
				for (Cell cell : row) {
					printCellContents(cell);
				}
			}
		}
	}

	private void printCellContents(Cell cell) {
		// Must do this, you need to get value based on the cell type
		switch (cell.getCellType()) {
		case HSSFCell.CELL_TYPE_NUMERIC:
			LOGGER.info("CELL_TYPE_NUMERIC: " + cell.getNumericCellValue());
			break;
		case HSSFCell.CELL_TYPE_STRING:
			LOGGER.info("CELL_TYPE_STRING: " + cell.getStringCellValue());
			break;
		default:
			LOGGER.info("CELL_TYPE_XXXX: " + cell);
			break;
		}
	}
}
