package Main;

import Classes.Client;
import Classes.ExcelReader;
import DataStructures.HashTable;
import DataStructures.List;
import Interfaces.Excel;

/**
 *
 * @author Mafer
 */
public class Main implements Excel{
    
    public static void main(String[] args) {
        Client c = new Client("29677861", "Juan", "Nunes", "email.com", "male", "21/04/2003");
        Client cf = new Client("12341234", "Pedrito", "Perez", "2341234", "m12341234", "12431234/2003");
        
        HashTable ht = new HashTable(500);
        
        ht.insert(c, "name", "lastName");
        ht.insert(cf, "name", "lastName");
        
        
        
        
        
        
    }
    
}
