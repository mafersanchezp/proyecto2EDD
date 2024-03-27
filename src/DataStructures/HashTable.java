package DataStructures;

import Classes.State;

/**
 *
 * @author Mafer
 * @param <T>
 */
public class HashTable<T> extends GenericData {
    private List[] table;

    public HashTable(int size) {
        this.table = new List[size];
        
        for (int i = 0; i < size; i++) {                        
            this.table[i] = new List();
        }
    }

    public List[] getTable() {
        return table;
    }

    public void setTable(List[] table) {
        this.table = table;
    }
    
            
    private int hash(T... values){
        int idx = 0;
        
        if(values.length == 1){
            
            T value = values[0];            
            if(value.getClass().getSimpleName().equals("String")){
                
                String valueStr = (String) value;
                idx += sumStr(valueStr);
            }
            else if(value.getClass().getSimpleName().equals("Integer")){
                
                Integer valueInt = (Integer) value;
                idx += sumInt(valueInt);
            }
        }
        else{
            for (T value: values) {                
                if(value.getClass().getSimpleName().equals("String")){

                    String valueStr = (String) value;
                    idx += sumStr(valueStr);
                }
                else if(value.getClass().getSimpleName().equals("Integer")){
                    
                    Integer valueInt = (Integer) value;
                    idx += sumInt(valueInt);
                }
            }            
        }
        
        return idx % table.length;       
    }
    
    
    
    public void insert(T object, String... attributeNames){
        T[] values = (T[]) new Object[attributeNames.length];
                
        T data1 = getGenericData(object, attributeNames[0]);
        T data2 = getGenericData(object, attributeNames[1]);

        for (int i = 0; i < attributeNames.length; i++) {                                                
            values[i] = getGenericData(object, attributeNames[i]);            
        }
        
        int idx = hash(values);                        
        
        List bucket = this.table[idx];
        bucket.append(object);        
    }
    
    
    
    public T get(T... values_attributes){
        if(values_attributes.length % 2 != 0){
           throw new IllegalArgumentException("Por cada atributo debe de haber un valor");              
        }
        else{                        
            T[] objectValues = (T[]) new Object[values_attributes.length/2];
            T[] attributeNames = (T[]) new Object[values_attributes.length/2];
                        
            for (int i = 0, j = (values_attributes.length/2); j < values_attributes.length; i++, j++) {                
                objectValues[i] = values_attributes[i];
                attributeNames[i] = values_attributes[j];
            }
            
            int idx = hash(objectValues);                                  
            
            List<T> bucket = this.table[idx];
                        
            for (int i = 0; i < bucket.getSize(); i++) {
                T object = bucket.get(i);
                
                boolean find = false;
                for (int j = 0; j < objectValues.length; j++) {
                    T value = objectValues[j];
                    String attribute = (String) attributeNames[j];

                    T objectValue = getGenericData(object, attribute);                    
                    
                    find = value.equals(objectValue);
                }
                
                if(find){
                    return object;
                }
            }
        }
        return null;
    }
    
    
    public T remove(T... values_attributes){
        if(values_attributes.length % 2 != 0){
           throw new IllegalArgumentException("Por cada atributo debe de haber un valor");              
        }
        else{                        
            T[] objectValues = (T[]) new Object[values_attributes.length/2];
            T[] attributeNames = (T[]) new Object[values_attributes.length/2];
                        
            for (int i = 0, j = (values_attributes.length/2); j < values_attributes.length; i++, j++) {                
                objectValues[i] = values_attributes[i];
                attributeNames[i] = values_attributes[j];
            }
            
            int idx = hash(objectValues);                                  
            
            List<T> bucket = this.table[idx];
                        
            for (int i = 0; i < bucket.getSize(); i++) {
                T object = bucket.get(i);
                
                boolean find = false;
                for (int j = 0; j < objectValues.length; j++) {
                    T value = objectValues[j];
                    String attribute = (String) attributeNames[j];

                    T objectValue = getGenericData(object, attribute);                    
                    
                    find = value.equals(objectValue);
                }
                
                if(find){
                    bucket.pop(i);
                }
            }
        }
        return null;
    }
    
    
    
    
    
    
    
    
    
    

    
    
   
}
