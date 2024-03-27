package DataStructures;


/**
 *
 * @author Mafer
 * @param <T>
 */
public class BST<T> extends GenericData{
    //Atributos de la clase
    private NodeBST root;
    
    /**
     * Constructor 1: crea un arbol con raiz inicializada
     * @param rootData 
     */
    public BST(T rootData) {
        this.root = new NodeBST(rootData);
    }
     
    /**
     * Constructor 2: crea un arbol sin raiz inicializada     
     */
    public BST() {
        this.root = null;
    }
    
    /**
     * Obtiene la raiz del arbol
     * @return 
     */
    public NodeBST getRoot() {
        return root;
    }
    
    /**
     * Cambia la raiz del arbol
     * @param root 
     */
    public void setRoot(NodeBST root) {
        this.root = root;
    }
    
    /**
     * Metodo para insertar en el arbol
     * @param <T>
     * @param object: Objeto a insertar en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     */
    public <T extends Comparable<T>> void insert(T object, String sortAttribute){        
        insert(root, object, sortAttribute);
    }
    
    /**
     * Metodo para insertar en el arbol
     * @param <T>
     * @param object: Objeto a insertar en el arbol
     */
    public <T extends Comparable<T>> void insert(T object){
        insert(root, object);
    } 
    
    /**
     * Metodo para obtener un dato en el arbol
     * @param <T>
     * @param value: Valor que se buscara en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     * @return  
     */
    public <T extends Comparable<T>> T get(T value, String sortAttribute){
        return get(root, value, sortAttribute);
    }
    
    /**
     * Metodo para insertar en el arbol
     * @param <T>
     * @param value: Valor que se buscara en el arbol
     * @return 
     */
    public <T extends Comparable<T>> T get(T value){
        return get(root, value);
    }
    
    /**
     * Metodo para eliminar en el arbol
     * @param <T>
     * @param value: Valor que se buscara en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     */
    public <T extends Comparable<T>> void remove(T value, String sortAttribute){
        remove(root, value, sortAttribute);
    }
    
    /**
     * Recorrer en preorden
     */
    public void preorder(){
        preorder(root);
    }
    
    /**
     * Recorrer en inorden
     */
    public void inorder(){
        inorder(root);
    }
    
    /**
     * Recorrer en postorden
     */
    public void postorder(){
        postorder(root);
    }
    
    /**
     * Metodo para insertar en el arbol
     * @param <T>
     * @param object: Objeto a insertar en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     * @param current: Nodo actual del recorrido
     */ 
    private <T extends Comparable<T>> void insert(NodeBST current, T object, String sortAttribute){        
        if(root == null){
            root = new NodeBST(object);
        }
        else{
            String currentData = getGenericData(current.getData(), sortAttribute);
            String objectData = getGenericData(object, sortAttribute);                        
            
            if(lessThan(objectData, currentData)){
                if(current.getLeft() == null){
                    current.setLeft(new NodeBST(object));
                }
                else{
                    insert(current.getLeft(), object, sortAttribute);                    
                }
            }
            else if(greaterThan(objectData, currentData)){
                if(current.getRight() == null){
                    current.setRight(new NodeBST(object));
                }
                else{
                    insert(current.getRight(), object, sortAttribute);                    
                }
            }
            else if(objectData.equals(currentData)){
                current.setData(object);
            }                        
        }
    }
    
    
    /**
     * Metodo para insertar en el arbol
     * @param <T>
     * @param object: Objeto a insertar en el arbol
     * @param current: Nodo actual del recorrido
     */ 
    private <T extends Comparable<T>> void insert(NodeBST current, T object){        
        if(root == null){
            root = new NodeBST(object);
        }
        else{
            T currentData = (T) current.getData();
            T objectData = object;
            
            if(lessThan(objectData, currentData)){
                if(current.getLeft() == null){
                    current.setLeft(new NodeBST(object));
                }
                else{
                    insert(current.getLeft(), object);                    
                }
            }
            else if(greaterThan(objectData, currentData)){
                if(current.getRight() == null){
                    current.setRight(new NodeBST(object));
                }
                else{
                    insert(current.getRight(), object);                    
                }
            }
            else if(objectData.equals(currentData)){
                current.setData(object);
            }                        
        }
    }
    
    /**
     * Metodo para obtener un dato en el arbol
     * @param <T>
     * @param value: Valor que se buscara en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     * @param current: Nodo actual del recorrido
     * @return  
     */
    private <T extends Comparable<T>> T get(NodeBST current, T value, String sortAttribute){
        if(root != null){
            T currentData = getGenericData(current.getData(), sortAttribute);
                        
            if(lessThan(value, currentData)){
                return get(current.getLeft(), value, sortAttribute);                                    
            }
            else if(greaterThan(value, currentData)){
                return get(current.getRight(), value, sortAttribute); 
            }
            else if(value.equals(currentData)){
                return (T) current.getData();
            }                        
        }
        return null;
    }
    
    
    /**
     * Metodo para obtener un dato en el arbol
     * @param <T>
     * @param value: Valor que se buscara en el arbol
     * @param current: Nodo actual del recorrido
     * @return  
     */
    private <T extends Comparable<T>> T get(NodeBST current, T value){
        if(root != null){
            T currentData = (T) current.getData();
            
            if(lessThan(value, currentData)){
                return get(current.getLeft(), value);                                    
            }
            else if(greaterThan(value, currentData)){
                return get(current.getRight(), value); 
            }
            else if(value.equals(currentData)){
                return (T) current.getData();
            }                        
        }
        return null;
    }
    
    /**
     * Metodo para eliminar en el arbol
     * @param <T>
     * @param current: Nodo actual del recorrido
     * @param value: Valor que se buscara en el arbol
     * @param sortAttribute: Atributo por el cual se haran las comparaciones 
     */
    private <T extends Comparable<T>> T remove(NodeBST current, T value, String sortAttribute){
        if(root != null){
            T rootData = getGenericData(root.getData(), sortAttribute);
            
            if(value.equals(rootData)){                
                NodeBST succesor = findSuccessor(root);                    
                
                T succesorData = getGenericData(succesor.getData(), sortAttribute);
                remove(root, succesorData, sortAttribute);

                root.setData(succesor.getData()); 
            }
            else{
                
                T currentData = getGenericData(current.getData(), sortAttribute);

                NodeBST child = null;
                if(lessThan(value, currentData)){                
                    child = current.getLeft();                
                }                    
                else{
                    child = current.getRight();
                }
                                
                T childData = getGenericData(child.getData(), sortAttribute);            


                if(childData.equals(value)){

                    if(child.getLeft() == null && child.getRight() == null){                        
                        if(current.getLeft() == child){
                            current.setLeft(null);
                        }
                        else if(current.getRight() == child){
                            current.setRight(null);
                        }
                    }
                    else if(child.getLeft() != null && child.getRight() == null){                    
                        if(current.getLeft() == child){
                            current.setLeft(child.getLeft());
                        }
                        else if(current.getRight() == child){
                            current.setRight(child.getLeft());
                        }
                    }
                    else if(child.getLeft() == null && child.getRight() != null){                      
                        if(current.getLeft() == child){
                            current.setLeft(child.getRight());
                        }
                        else if(current.getRight() == child){
                            current.setRight(child.getRight());
                        }                    
                    }
                    else if(child.getLeft() != null && child.getRight() != null){
                        NodeBST succesor = findSuccessor(child);                    

                        T succesorData = getGenericData(succesor.getData(), sortAttribute);
                        remove(root, succesorData, sortAttribute);

                        child.setData(succesor.getData());                                                            
                    }                                                                
                }
                else{
                    remove(child, value, sortAttribute);
                }
            }            
        }
        return null;
    }
    
    public <T extends Comparable<T>> NodeBST findSuccessor(NodeBST node) {
        if (node == null) {
            return null;
        }
               
        if (node.getRight() != null) {
            NodeBST current = node.getRight();
            while (current.getLeft() != null) {
                current = current.getLeft();
            }
            return current;
        }
                
        NodeBST successor = null;
        NodeBST current = root;
        while (current != null) {
            T nodeData = (T) node.getData();
            T currentData = (T) current.getData();
            
            if (lessThan(nodeData, currentData)) {
                successor = current;
                current = current.getLeft();
                
            } else if (greaterThan(nodeData, currentData)) {
                current = current.getRight();
                
            } else {
                break; 
            }
        }
        return successor;
    }
    
        
    
    /**
     * Recorrer en preorden
     * @param current 
     */
    private void preorder(NodeBST current){
        if(current != null){
            System.out.println(current.getData());
            preorder(current.getLeft());
            preorder(current.getRight());
        }
    }
    
    /**
     * Recorrer en inorden
     * @param current 
     */
    private void inorder(NodeBST current){
        if(current != null){
            inorder(current.getLeft());
            System.out.println(current.getData());
            inorder(current.getRight());
        }
    }
    
    /**
     * Recorrer en postorden
     * @param current 
     */
    private void postorder(NodeBST current){
        if(current != null){
            postorder(current.getLeft());
            postorder(current.getRight());
            System.out.println(current.getData());
        }
    }
  
    
    
    
    
}

