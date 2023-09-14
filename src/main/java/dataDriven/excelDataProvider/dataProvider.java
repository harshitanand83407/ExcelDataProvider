package dataDriven.excelDataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvider {
	
	//multiple sets of data to our test
	//array 
	//5 sets of data as 5 arrays from data provider to your test
	//then your test will run 5 times with 5 seperate sets of data(arrays)
	@Test(dataProvider="driveTest")
	public void testCaseData(String greeting,String communication,int id )
{
	System.out.println(greeting + communication + id );
}
	
	@DataProvider(name="driveTest")
	public void getData() throws IOException
	{
		//Object[][] data= {{"hello","text",1},{"bye","text",143},{"solo","call",453}};
		//every row of excel
		FileInputStream fis = new FileInputStream("C://Users//hanand//excelDriven.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet = wb.getSheetAt(0);
		int rowCount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int colCount=row.getLastCellNum();
		Object[][] data = new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount;i++)
		{
			row=sheet.getRow(i);
			for (int j=0;j<colCount;j++)
			{
				System.out.println(row.getCell(j));
			}
		}
		
		//return data;
	}

}
