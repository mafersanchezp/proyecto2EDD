package Classes;

import DataStructures.BST;
import DataStructures.HashTable;
import Interfaces.Excel;
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
 * @param <T>
 */
public class ExcelReader implements Excel{
    
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
        
        String[][] excelValues = new String[rows-1][cells];
        
        for (int i = 1; i < rows; i++) {
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
                
                
                excelValues[i-1][j] = value;                
            }            
        }        
        return excelValues;                
    }
    
    
    
    public static HashTable getState(){
        HashTable stateTable = new HashTable(1500);
        
        String[][] stateValues = getSheetValues(STATE);
        
        for (String[] row: stateValues) {
                        
            State newState = new State(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);                        
            stateTable.insert(newState, "name", "lastName");
            
        }        
        return stateTable;
    }
    
    
    public static <T extends Comparable<T>> BST<Booking> getBooking(){
        BST<Booking> bookingBst = new BST<>();
        
        String[][] bookingValues = getSheetValues(BOOKING);
        
        for (String[] row: bookingValues) {
            
            Booking newBooking = new Booking(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
            bookingBst.insert((T) newBooking, "id");
            
        }
        
        return bookingBst;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
