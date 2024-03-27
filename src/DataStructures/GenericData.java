package DataStructures;

import java.lang.reflect.Field;

/**
 *
 * @author Mafer
 */
public class GenericData {
    
    /**
     * Obtiene el dato de un objeto dado su atributo
     * @param <A>
     * @param <B>
     * @param object
     * @param attributeName
     * @return 
     */
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
                System.out.println("Error: " + e);
                return null;
            }                       
        }        
    }
    
    /**
     * Suma los caracteres de un string
     * @param value
     * @return 
     */
    public static int sumStr(String value){
        int num = 0;
        
        char[] valueStrArray = value.toCharArray();

        for (char c: valueStrArray) {
            num += c;
        }
        
        return num;
    }
    
    /**
     * Suma los digitos de un numero
     * @param value
     * @return 
     */
    public static int sumInt(int value){
        int num = 0;
        
        String valueStr = Integer.toString(value);
        char[] valueStrArray = valueStr.toCharArray();
        
        for (char c: valueStrArray) {
            num += c;
        }
        
        return num;        
    }
    
    /**
     * Devuelde el campo del objeto dado un atibuto
     * @param <T>
     * @param object
     * @param name
     * @return 
     */
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
    
    /**
     * Compara si un dato generico es mayor que otro
     * @param <T>
     * @param objectA
     * @param objectB
     * @return 
     */
    public static <T extends Comparable<T>> boolean greaterThan(T objectA, T objectB){
        return objectA.compareTo(objectB) > 0;
    }
    
    /**
     * Compara si un dato generico es menor que otro
     * @param <T>
     * @param objectA
     * @param objectB
     * @return 
     */
    public static <T extends Comparable<T>> boolean lessThan(T objectA, T objectB){        
        return objectA.compareTo(objectB) < 0;
    }
    
    
    
}
