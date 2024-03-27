package DataStructures;

/**
 *
 * @author Mafer
 * @param <T>
 */
public class Node<T> {
    //Atributos de la clase      
    private T data;
    private Node<T> next;    
    
        
    /**
     * Constructor de la clase Nodo
     * @param data 
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }
    
    /**
     * Obtiene el dato almacenado en el nodo
     * @return 
     */
    public T getData() {
        return data;
    }
    
    /**
     * Cambia el dato del nodo
     * @param data 
     */
    public void setData(T data) {
        this.data = data;
    }
    
    /**
     * Obtiene el siguiente del nodo
     * @return 
     */
    public Node<T> getNext() {
        return next;
    }
    
    /**
     * Cambia el siguiente del nodo
     * @param next 
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }
    
    
    
    
}
