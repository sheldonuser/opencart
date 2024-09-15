package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testdata\\testdata.xlsx"; //taking excel file from testdata
		
		ExcelUtility xlutil=new ExcelUtility(path); //creating object for xlutility
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totlcols=xlutil.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totlcols]; //created for two dimension array which can
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totlcols;j++)
			{
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				
			}
		}
		return logindata;
	}

}
