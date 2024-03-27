package DataStructures;

import java.util.NoSuchElementException;

/**
 *
 * @author Mafer
 * @param <T>
 */
public class List<T>{
    //Atributos de la clase
    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Constructor 1: Inicia la lista vacia
     */
    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    /**
     * Constructor 2: Inicia la lista con elementos
     * @param dataArray 
     */
    public List(T... dataArray){
        for(T data: dataArray){
            append(data);
        }
    }
    
    /**
     * Obtiene la cabeza
     * @return 
     */
    public Node<T> getHead() {
        return head;
    }
    
    /**
     * Cambia la cabeza
     * @param head 
     */
    public void setHead(Node<T> head) {
        this.head = head;
    }
    
    /**
     * Obtiene la cola
     * @return 
     */
    public Node<T> getTail() {
        return tail;
    }
    
    /**
     * Cambia la cola
     * @param tail 
     */
    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
    
    /**
     * Obtiene el tamaño
     * @return 
     */
    public int getSize() {
        return size;
    }
    
    /**
     * Cambia el tamaño 
     * @param size
     */
    public void setSize(int size) {
        this.size = size;
    }
    
    /**
     * Devuelve true si la lista esta vacia
     * @return 
     */
    public boolean isEmpty(){
        return this.head == null;
    }
    
    /**
     * Obtiene el ultimo indice de la lista
     * @return 
     */
    public int lastIdx(){
        return this.size-1;
    }
    
    /**
     * Agrega al final de la lista
     * @param data 
     */
    public void append(T data){
        if(isEmpty()){
            this.head = this.tail = new Node(data);
        }
        else{
            Node newNode = new Node(data);
            this.tail.setNext(newNode);
            this.tail = newNode;
        }
        this.size++;
    }
    
    /**
     * Agrega al inicio de la lista
     * @param data 
     */
    public void preappend(T data){
        if(isEmpty()){
            this.head = this.tail = new Node(data);
        }
        else{
            Node newNode = new Node(data);
            newNode.setNext(this.head);
            this.head = newNode;
        }
        this.size++;
    }
    
    
    /**
     * Inserta un elemento dado un indice
     * @param data
     * @param idx 
     */
    public void insert(T data, int idx){
        if(isEmpty()){
            this.head = this.tail = new Node(data);
        }
        else{
            if(idx < 0 || idx > lastIdx()){
                throw new IndexOutOfBoundsException("Indice " + idx + " no valido para un rango de 0 a " + this.size);
            }
            else if(idx == 0){
                preappend(data);
            }            
            else{
                Node newNode = new Node(data);
                
                Node pointer = this.head;
                for (int i = 0; i < lastIdx(); i++) {
                    pointer = pointer.getNext();
                }
                
                newNode.setNext(pointer.getNext());
                pointer.setNext(newNode);
                this.size++;
            }
        }
    }
    
    /**
     * Elimina el primero de la lista
     * @return 
     */
    public T removeHead(){
        if(isEmpty()){
            throw new NoSuchElementException("Lista vacia");
        }
        else{
            T data = this.head.getData();
            this.head = this.head.getNext();
            this.size--;
            return data;
        }
    }
    
    /**
     * Elimina el ultimo de la lista
     * @return 
     */
    public T removeTail(){
        if(isEmpty()){
            throw new NoSuchElementException("Lista vacia");
        }
        else{
            Node pointer = this.head;
            for (int i = 0; i < lastIdx()-1; i++) {
                pointer = pointer.getNext();
            }
            T data = this.tail.getData();
            pointer.setNext(null);
            this.tail = pointer;
            this.size--;
            return data;
        }
    }
    
    /**
     * Elimina el elemento del indice 
     * @param idx
     * @return 
     */
    public T pop(int idx){
        if(isEmpty()){
            throw new NoSuchElementException("Lista vacia");
        }
        else{
            if(idx < 0 || idx > lastIdx()){
                throw new IndexOutOfBoundsException("Indice " + idx + " no valido para un rango de 0 a " + this.size);
            }
            else if(idx == 0){
                return removeHead();
            }       
            else if(idx == lastIdx()){
                return removeTail();
            }
            else{
                Node pointer = this.head;
                for (int i = 0; i < idx-1; i++) {
                    pointer = pointer.getNext();
                }
                T data = (T) pointer.getNext().getData();
                pointer.setNext(pointer.getNext().getNext());
                this.size--;
                return data;
            }
        }        
    }
    
    /**
     * Obtiene el elemento del indice
     * @param idx
     * @return 
     */
    public T get(int idx){
        if(isEmpty()){
            throw new NoSuchElementException("Lista vacia");
        }
        else{            
            if(idx < 0 || idx > lastIdx()){
                throw new IndexOutOfBoundsException("Indice " + idx + " no valido para un rango de 0 a " + lastIdx());
            }
            else if(idx == 0){
                return this.head.getData();
            }       
            else if(idx == lastIdx()){
                return this.tail.getData();
            }
            else{
                Node pointer = this.head;
                for (int i = 0; i < idx; i++) {
                    pointer = pointer.getNext();
                }
                T data = (T) pointer.getData();
                return data;
            }
        }    
    }
    
    /**
     * Devuelve true si data esta en la lista
     * @param data
     * @return 
     */
    public boolean contains(T data){
        if(isEmpty()){
            return false;
        }
        else{
            Node pointer = this.head;
            for (int i = 0; i < lastIdx(); i++) {
                if(pointer.getData().equals(data)){
                    return true;
                }
                pointer = pointer.getNext();
            }
            
            return false;
        }
    }
    
    /**
     * Metodo para imprimir la lista
     * @return 
     */
    @Override
    public String toString(){            
        String str = "[";
        if(!isEmpty()){
            
            Node pointer = this.head;
            while(pointer != null){
                if(pointer.getNext() == null){
                    str += pointer.getData();
                }
                else{
                    str += pointer.getData() + ", ";
                }
                pointer = pointer.getNext();
            }
            
        }
        str += "]";
        return str;
    }
    
}
