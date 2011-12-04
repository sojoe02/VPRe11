/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.trees;

import java.util.ArrayList;

/**
 *
 * @author sojoe
 */
public class Traversal {
    ArrayList<AvlNode> activeNodes = new ArrayList<AvlNode>();
    AvlTree tree;
    
    public Traversal(AvlTree tree){
        this.tree = tree;           
    }
    
    public void DFSpostOrder(){
        System.out.println();
    }
    
    public void DFSInOrder(){
        
    }
    
    public void BFS(){       
    }
  
}
