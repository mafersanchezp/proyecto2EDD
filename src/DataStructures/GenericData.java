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
        
    public static <A, B> B getGenericData(A object, String attributeName){
        if(object.getClass().getSimpleName().equals("String")){
            return (B) object;
        }
        else{
            try{
                Field field = getAttributeField(object, attributeName);
                
                field.setAccessible(true); 
                B value = (B) field.get(object);  
                                
                return value;
            }
            catch(Exception e){
                System.out.println(e);
                return null;
            }                       
        }        
    }
    
    
    public static int sumStr(String value){
        int num = 0;
        
        char[] valueStrArray = value.toCharArray();

        for (char c: valueStrArray) {
            num += c;
        }
        
        return num;
    }
    
    
    public static int sumInt(int value){
        int num = 0;
        
        String valueStr = Integer.toString(value);
        char[] valueStrArray = valueStr.toCharArray();
        
        for (char c: valueStrArray) {
            num += c;
        }
        
        return num;        
    }
    
    public static <T> Field getAttributeField(T object, String name){
        Field[] fieldsBase = object.getClass().getDeclaredFields();
        Field[] fieldsSuper = object.getClass().getSuperclass().getDeclaredFields();
        
        for(Field field: fieldsBase){
            if(field.getName().equals(name)){
                return field;
            }
        }
        
        for(Field field: fieldsSuper){
            if(field.getName().equals(name)){
                return field;
            }
        }                
        
        return null;
    }
}
