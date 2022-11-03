package ExcelValidation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.sound.sampled.TargetDataLine;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDrive_MainMethod {
	
	public ArrayList<String> getData(String testCaseName) throws IOException
	{
		ArrayList<String> array = new ArrayList<String>();
		
		FileInputStream fis = new FileInputStream("D:\\Automation\\API-Postman-RestAssured\\Exel-Data Read\\TestData.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(fis);
		int sheets = workBook.getNumberOfSheets();
		for(int i=0; i<sheets; i++)
		{
			if(workBook.getSheetName(i).equalsIgnoreCase("testdata"))
			{
				XSSFSheet sheet = workBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRows = rows.next();
				Iterator<Cell> cells = firstRows.cellIterator();
				int Col_incrementer = 0;
				int column = 0;
				while(cells.hasNext())
				{
					Cell value = cells.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						column = Col_incrementer;
						break;
					}
					Col_incrementer++;
				}
				int row_incrementer = 0;
				while(rows.hasNext())
				{
					Row r = rows.next();
					
					if(r.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName))
					{
						Iterator<Cell> cv = r.cellIterator();
						while(cv.hasNext())
						{
							Cell c = cv.next();
							if(c.getCellType()==CellType.STRING)
							{
								array.add(c.getStringCellValue());
							}else {
								array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
							
						}
					}
				}
			}
			
		}
		return array;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
//		getData("Add Profile");
		dataDrive_MainMethod d = new dataDrive_MainMethod();
//		dataDriven ds = new dataDriven();
		ArrayList data = d.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3));
	}

	

}
