package Classes;

import DataStructures.BST;
import DataStructures.HashTable;
import Interfaces.Excel;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 *
 * @author Mafer
 */
public class ExcelReader implements Excel{
    
    
    /**
     * Metodo para obtener una hoja del excel
     * @param sheetNum
     * @return 
     */
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
    
    /**
     * Metodo para obtener una matriz con los valores de la hoja
     * @param sheetNum
     * @return 
     */
    private static String[][] getSheetValues(int sheetNum){
        Sheet sheet = getExcelSheet(sheetNum);  
        
        int rows = sheet.getPhysicalNumberOfRows();
        int cells = sheet.getRow(0).getPhysicalNumberOfCells();
        
        String[][] excelValues = new String[rows-1][cells];
        
        for (int i = 1; i < rows; i++) {
            Row row = sheet.getRow(i);
            
            for (int j = 0; j < cells; j++) {
                Cell cell = row.getCell(j);
                
                String value = "";
                if(cell != null){
                    if(cell.getCellTypeEnum() == CellType.FORMULA){
                        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yy");
                        Date date = cell.getDateCellValue();
                        value = formatter.format(date);                        
                    }
                    else{
                        DataFormatter dataFormatter = new DataFormatter();
                        value = dataFormatter.formatCellValue(cell);                        
                    }
                }
                
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
    
    
    /**
     * Metodo que convierte la matriz de la hoja de estado en un hashTable
     * @return 
     */
    public static HashTable getState(){
        HashTable stateTable = new HashTable(1500);
        
        String[][] stateValues = getSheetValues(STATE);
        
        for (int i = 0; i < stateValues.length; i++) {
            String[] row = stateValues[i];
            
            if(row[0] == null){
                row[0] = stateValues[i-1][0];
            }
            
            State newState = new State(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);                        
            stateTable.insert(newState, "name", "lastName");
        }
      
        return stateTable;
    }
    
    /**
     * Metodo que convierte la matriz de la hoja de reserva en un BST
     * @param <T>
     * @return 
     */
    public static <T extends Comparable<T>> BST<Booking> getBooking(){
        BST<Booking> bookingBst = new BST<>();
        
        String[][] bookingValues = getSheetValues(BOOKING);
        
        for (String[] row: bookingValues) {
            
            row[0] = row[0].replace(".", "");
            Booking newBooking = new Booking(row[0], row[1], row[2], row[3], row[4], row[5], row[6], row[7], row[8]);
            bookingBst.insert((T) newBooking, "id");
            
        }
        
        return bookingBst;
    }
    
    /**
     * Metodo que convierte la matriz de la hoja de historial en un BST
     * @param <T>
     * @return 
     */
    public static <T extends Comparable<T>> BST<Booking> getRecord(){
        BST<Booking> recordBst = new BST<>();
        
        String[][] recordValues = getSheetValues(RECORD);
        
        for (String[] row: recordValues) {
            
            row[0] = row[0].replace(".", "");            
            Record newRecord = new Record(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
            recordBst.insert((T) newRecord, "id");
            
        }
        
        return recordBst;
    }
    
    /**
     * Metodo que convierte la matriz de la hoja de historial en un BST
     * ordenado por el numero de habitacion
     * @param <T>
     * @return 
     */
    public static <T extends Comparable<T>> BST<RoomGroup> getRoomGroup(){
        BST<RoomGroup> roomGroupBst = new BST<>();
        
        String[][] recordValues = getSheetValues(RECORD);
        
        RoomGroup[] rooms = new RoomGroup[300];
        for (int i = 0; i < 300; i++) {
            RoomGroup rg = new RoomGroup(Integer.toString(i+1));
            rooms[i] = rg;
        }
        
        for (String[] row: recordValues) {
            
            row[0] = row[0].replace(".", "");
            Record newRecord = new Record(row[0], row[1], row[2], row[3], row[4], row[5], row[6]);
            
            int roomNum = Integer.parseInt(row[6]);
            rooms[roomNum-1].getGroup().append(newRecord);            
               
        }
        
        for(RoomGroup rg: rooms){
            roomGroupBst.insert((T) rg, "roomNum");
        }
        return roomGroupBst;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}
