package PageObjectModel;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Sheet;

 
public class ExcelUtil 

{

	public static Object[][] getEcelData(String path, String sheetName) throws Exception

	{

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook= WorkbookFactory.create(fis);

		Sheet sheet= workbook.getSheet(sheetName);

		int rowCount= sheet.getPhysicalNumberOfRows();

		int colCount= sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] data= new Object[rowCount-1][colCount];

		for(int i=1; i < rowCount; i++)

		{

			for(int j=0; j <colCount; j++)

			{

				data[i-1][j]= sheet.getRow(i).getCell(j).toString();

			}

		}

		workbook.close();

		return data;

		}

}

 