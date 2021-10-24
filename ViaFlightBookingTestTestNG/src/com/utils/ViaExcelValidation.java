package com.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ViaExcelValidation {
	
	public static void main(String[] args) throws Exception {
		/*FileInputStream ofile = new FileInputStream("D:\\Selenium\\Sheet1.xlsx");
		XSSFWorkbook oworkbook = new XSSFWorkbook(ofile);
		XSSFSheet osheet = oworkbook.getSheet("Via Flight Booking");
		XSSFRow orow = osheet.getRow(1);
		XSSFCell ocell = orow.getCell(0);
		String value = ocell.getStringCellValue();*/
		
		ViaExcelUtils oexcelutil = new ViaExcelUtils("D:\\Selenium\\Sheet1.xlsx", "Via Flight Booking");
		String childYOB = oexcelutil.getCellData(1, "ChildYOB");
		System.out.println("Year Of Birth of the Child "+childYOB);
	}

}
