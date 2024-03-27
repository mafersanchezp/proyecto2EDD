/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataStructures;

import static DataStructures.GenericData.getGenericData;
import static DataStructures.GenericData.greaterThan;
import static DataStructures.GenericData.lessThan;

/**
 *
 * @author Mafer
 */
public class facadeBST {
    
    
    private <T extends Comparable<T>> void insert(NodeBST root, T object, String sortAttribute){
        if(root == null){
            root = new NodeBST(object);
        }
        else{
            T currentData = getGenericData(root.getData(), sortAttribute);
            T objectData = getGenericData(object, sortAttribute);
            
            if(lessThan(objectData, currentData)){
                if(root.getLeft() == null){
                    root.setLeft(new NodeBST(object));
                }
                else{
                    insert(root.getLeft(), object, sortAttribute);                    
                }
            }
            else if(greaterThan(objectData, currentData)){
                if(root.getRight() == null){
                    root.setRight(new NodeBST(object));
                }
                else{
                    insert(root.getRight(), object, sortAttribute);                    
                }
            }
            else if(objectData.equals(currentData)){
                throw new IllegalArgumentException("No pueden haber elementos repetidos");
            }                        
        }
    }
    
    
    
    
}
