package com.ecalix.tests;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDriven {
	
	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static FileInputStream fis;
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		fis = new FileInputStream("/Users/yanbochen/Documents/workspaceQA/TestScript/testData.xlsx");	
        String username = getCelldata(1,1);
        
	}
	
	public static String getCelldata(int rownum, int colnum) throws IOException{
		
		wb = new XSSFWorkbook(fis);
		sheet = wb.getSheet("sheet1");
		row = sheet.getRow(1);
		cell = row.getCell(1);
		return cell.getStringCellValue();
		
	}

}
