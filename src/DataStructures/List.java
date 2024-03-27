package DataStructures;

import java.util.NoSuchElementException;

/**
 *
 * @author Mafer
 * @param <T>
 */
public class List<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public List() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
    public List(T... dataArray){
        for(T data: dataArray){
            append(data);
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty(){
        return this.head == null;
    }
    
    public int lastIdx(){
        return this.size-1;
    }
    
    
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
    
    @Override
    public String toString(){
        String str = null;
        if(!isEmpty()){
            str = "[";
            
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
            str += "]";
            
        }
        return str;
    }
    
}
