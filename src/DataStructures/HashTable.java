package DataStructures;


/**
 *
 * @author Mafer
 * @param <T>
 */
public class HashTable<T> extends GenericData {
    //Atributos de la clase
    private List[] table;

    /**
     * Constructor
     * @param size 
     */
    public HashTable(int size) {
        this.table = new List[size];
        
        for (int i = 0; i < size; i++) {                        
            this.table[i] = new List();
        }
    }
    
    /**
     * Obtiene la tabla
     * @return 
     */
    public List[] getTable() {
        return table;
    }
    
    /**
     * Cambia la tabla
     * @param table 
     */
    public void setTable(List[] table) {
        this.table = table;
    }
    
    /**
     * Obtiene el tamaño
     * @return 
     */
    public int getSize(){
        return this.table.length;
    }
    
     /**
      * Metodo de dispersion
      * @param values
      * @return 
      */       
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
    
    
    /**
     * Metodo para insertar en el hashTable
     * @param object
     * @param attributeNames 
     */
    public void insert(T object, String... attributeNames){
        T[] values = (T[]) new Object[attributeNames.length];
        
        if(attributeNames.length == 2){
            T data1 = getGenericData(object, attributeNames[0]);
            T data2 = getGenericData(object, attributeNames[1]);

            for (int i = 0; i < attributeNames.length; i++) {                                                
                values[i] = getGenericData(object, attributeNames[i]);            
            }

            int idx = hash(values);                        

            List bucket = this.table[idx];
            bucket.append(object);                    
        }
    }
    
    
    /**
     * Metodo para obtener del hashTable
     * @param values_attributes
     * @return 
     */
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
    
    /**
     * Metodo para eliminar del hashTable
     * @param values_attributes
     * @return 
     */
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
