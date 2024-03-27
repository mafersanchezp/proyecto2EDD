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
public class HashTable<T> extends GenericData {
    private List[] table;

    public HashTable(int size) {
        this.table = new List[size];
        
        for(List bucket: this.table){
            bucket = new List();
        }
    }

    public List[] getTable() {
        return table;
    }

    public void setTable(List[] table) {
        this.table = table;
    }

    
    public int hash(T data, String... attributeNames){
        int value = 0;
        if(attributeNames.length == 1){
            String attributeName = attributeNames[0];
            String attributeValue = getGenericData(data, attributeName);
            char[] valueArray = attributeValue.toCharArray();
            
            for(char c: valueArray){
                value += c;
            } 
        }
        else{
            for (String attributeName: attributeNames) {
                String attributeValue = getGenericData(data, attributeName);
                char[] valueArray = attributeValue.toCharArray();
                for(char c: valueArray){
                    value += c;
                } 
            }
        }
        return value % table.length;
    }
    
    
    
    public void insert(T data, String... attributeNames){
        int idx = hash(data, attributeNames);
        
        List bucket = this.table[idx];
        bucket.append(data);
    }
    
    
    
    public T get(T value, String... attributeNames){
        if(attributeNames.length == 1){
            
        }
        else{
            
        }
    }
    
    
   
}
