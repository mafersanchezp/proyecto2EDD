package DataStructures;

import Classes.Room;

/**
 *
 * @author Mafer
 * @param <T>
 */
public class BST<T> extends GenericData{
    private NodeBST root;

    public BST(T rootData) {
        this.root = new NodeBST(rootData);
    }
    
    public BST() {
        this.root = null;
    }

    public NodeBST getRoot() {
        return root;
    }

    public void setRoot(NodeBST root) {
        this.root = root;
    }
    
    
    public <T extends Comparable<T>> void insert(T object, String sortAttribute){
        insert(root, object, sortAttribute);
    }
    
    public <T extends Comparable<T>> void insert(T object){
        insert(root, object);
    } 
    
    
    public <T extends Comparable<T>> T get(T value, String sortAttribute){
        return get(root, value, sortAttribute);
    }
    
    public <T extends Comparable<T>> T get(T value){
        return get(root, value);
    }
    
    public <T extends Comparable<T>> void remove(T value, String sortAttribute){
        remove(root, value, sortAttribute);
    }
    
    
    public void preorder(){
        preorder(root);
    }
    
    public void inorder(){
        inorder(root);
    }
    
    public void postorder(){
        postorder(root);
    }
    
      
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
    
    
    private <T extends Comparable<T>> T remove(NodeBST current, T value, String sortAttribute){
        if(root != null){
            T rootData = getGenericData(root.getData(), sortAttribute);
            
            if(value == rootData){
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


                if(childData == value){

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
    
        
    
    
    private void preorder(NodeBST current){
        if(current != null){
            System.out.println(current.getData());
            preorder(current.getLeft());
            preorder(current.getRight());
        }
    }
    
    private void inorder(NodeBST current){
        if(current != null){
            inorder(current.getLeft());
            System.out.println(current.getData());
            inorder(current.getRight());
        }
    }
    
    private void postorder(NodeBST current){
        if(current != null){
            postorder(current.getLeft());
            postorder(current.getRight());
            System.out.println(current.getData());
        }
    }
  
    
    
    
    
}

