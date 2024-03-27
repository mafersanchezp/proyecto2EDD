package DataStructures;

/**
 *
 * @author Mafer
 */
public class NodeBST<T> {
    //Atributos de la clase
    private T data;
    private NodeBST left;
    private NodeBST right;
    
    /**
     * Constructor
     * @param data 
     */
    public NodeBST(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
    
    /**
     * Obtiene el dato del nodo
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
     * Obtiene el hijo izquierdo
     * @return 
     */
    public NodeBST getLeft() {
        return left;
    }
    
    /**
     * Cambia el hijo izquierdo
     * @param left 
     */
    public void setLeft(NodeBST left) {
        this.left = left;
    }
    
    /**
     * Obtiene el hijo derecho
     * @return 
     */
    public NodeBST getRight() {
        return right;
    }
    
    /**
     * Cambia el hijo derecho
     * @param right 
     */
    public void setRight(NodeBST right) {
        this.right = right;
    }
    
    
}
