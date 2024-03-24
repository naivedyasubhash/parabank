package com.parabank.utility;

import java.io.IOException;

import org.testng.annotations.DataProvider;


public class DataProviders {
	@DataProvider(name="RegisterData")
	public String[][] getRegisterData() throws IOException{

		String path=".\\testdata\\RegisterData.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		int totalrows=excel.getRowCount("Sheet1");
		int totalcols=excel.getCellCount("Sheet1", 1);
		String registerData[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				registerData[i-1][j]=excel.getCellData("Sheet1", i, j);
			}
		}
		return registerData;
		
	}
	
	@DataProvider(name="LoginData")
	public String[][] getLoginData() throws IOException{

		String path=".\\testdata\\RegisterData.xlsx";
		ExcelUtility excel=new ExcelUtility(path);
		int totalrows=excel.getRowCount("Sheet2");
		int totalcols=excel.getCellCount("Sheet2", 1);
		String loginData[][]=new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++) {
			for(int j=0;j<totalcols;j++) {
				loginData[i-1][j]=excel.getCellData("Sheet2", i, j);
			}
		}
		return loginData;
		
	}
	

}
