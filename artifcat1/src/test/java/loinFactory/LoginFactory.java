package loinFactory;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Listeners;

import loginTest.LoginTest;

@Listeners(extentReport.ExtentReport.class)
public class LoginFactory {
	
	@Factory(dataProvider="data")
	public Object[] factory(String UserName, String Password) {
		System.out.println("b");
		System.out.println(UserName + " " +Password);
		return new Object[] {new LoginTest(UserName, Password)};
	}
	
	
	@DataProvider(parallel=true)
	public static Object[][] data() throws InvalidFormatException, IOException {
		System.out.println("a");
		String proj_path=System.getProperty("user.dir");
		System.out.println("b");
		File file=new File("C:\\Users\\amalbari\\Desktop\\Username.xlsx");
		  XSSFWorkbook wb=new XSSFWorkbook(file);
		  XSSFSheet sheet=(XSSFSheet) wb.getSheetAt(0);
		   int row= sheet.getPhysicalNumberOfRows();//5
		  int col= sheet.getRow(0).getPhysicalNumberOfCells();//3
		  System.out.println("Row "+row);
		  System.out.println("Col "+col);
		  
		  String [][]a= new String [row-1][col];//
		  
		  for(int i=1;i<=row-1;i++)
		  {
			  
			  for (int j=0;j<col;j++) {
				 a[i-1][j]=sheet.getRow(i).getCell(j).toString();
				 System.out.println(i + " " +j +" "+ a[i-1][j]);
			  }
		  }
		return a;
	}
	
}