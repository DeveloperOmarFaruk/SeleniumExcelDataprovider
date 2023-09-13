package ExcelFileDataprovide;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.apache.poi.ss.usermodel.DataFormatter;

public class ExcelDataSupplier {
	
    @DataProvider(name = "LoginTestData")
	public String[][] getData() throws IOException {
		
		 //Create an object of File class to open xlsx file
        File ExcelFile = new File("./src/test/resources/loginData.xlsx");
        
        //Create an object of FileInputStream class to read excel file
        FileInputStream inputStream = new FileInputStream(ExcelFile);
        
      //Creating workbook instance that refers to .xls file
        XSSFWorkbook workBook = new XSSFWorkbook(inputStream);
        
      //Creating a Sheet object using the sheet Name
        XSSFSheet sheet = workBook.getSheet("loginSheet");
        
        
     
        int numberOfRows = sheet.getPhysicalNumberOfRows();
        int numberOfColums = sheet.getRow(0).getLastCellNum();
        
        String[][] data = new String[numberOfRows-1][numberOfColums];
        
        for(int i = 0; i < numberOfRows-1; i++) {
        	for(int j = 0; j < numberOfColums; j++ ) {
        		DataFormatter df = new DataFormatter();
        		data[i][j] = df.formatCellValue(sheet.getRow(i+1).getCell(j));

        	}
        }
        
        
        return data;

	}

}
