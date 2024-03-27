/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import java.lang.reflect.Field;

/**
 *
 * @author Mafer
 */
public class GenericData {
    
    
    public static <T> String getGenericData(T data, String attributeName){
        Field[] fields = data.getClass().getDeclaredFields();
        
        boolean find = false;
        for(Field field: fields){
            if(field.getName().equals(attributeName)){
                find = true;
            }            
        }
        
        if(find){
            try{
                Field field = data.getClass().getDeclaredField(attributeName);
                field.setAccessible(true); 
                String value = (String) field.get(data);   
                return value;
                
            }
            catch(Exception e){
                System.out.println(e);
            }
        }
        return null;
    }
}
