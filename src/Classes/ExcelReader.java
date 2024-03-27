package Classes;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Mafer
 */
public class ExcelReader{
    
    private static Sheet getExcelSheet(int sheetNum){
        String root = "Booking_hotel.xlsx";
        
        try{
            Workbook book = WorkbookFactory.create(new FileInputStream(root));
            if(sheetNum < 0 || sheetNum > book.getNumberOfSheets()-1){
                String str = "Hoja" + sheetNum + " no valido para un rango de 0 a ";
                str += (book.getNumberOfSheets()-1);
                
                throw new IndexOutOfBoundsException(str);
            }
            else{
                Sheet sheet = book.getSheetAt(sheetNum);
                return sheet;                
            }
                
            
        }
        catch(Exception e){
            System.out.println(e); 
        }
        return null;
    }
    
    
    private static String[][] getSheetValues(int sheetNum){
        Sheet sheet = getExcelSheet(sheetNum);  
        
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getPhysicalNumberOfCells();
        
        String[][] excelValues = new String[rows][cells];
        
        for (int i = 0; i < rows; i++) {
            Row row = sheet.getRow(i);
            
            for (int j = 0; j < cells; j++) {
                Cell cell = row.getCell(j);
                
                DataFormatter dataFormatter = new DataFormatter();
                String value = dataFormatter.formatCellValue(cell);
                
                if(j == 0){
                    if(value.isBlank()){
                        value = excelValues[i-1][j];
                    }
                }
                
                
                excelValues[i][j] = value;                
            }            
        }        
        return excelValues;                
    }
    
    
    
    
    
    
    
    
    
}
