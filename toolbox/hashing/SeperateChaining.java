/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.hashing;

import interfaces.Constants;
import java.util.LinkedList;
import java.util.List;
import toolbox.math.FindPrime;

/**
 *
 * @author sojoe
 */
public class SeperateChaining<Type> implements Constants{
    
    private LinkedList[] chainList;
    private int nmbrItems;
    
    public SeperateChaining(){
        this(DEFAULT_TABLE_SIZE);
    }
    
    public SeperateChaining(int size){
        
        nmbrItems = 0;
        
        chainList = new LinkedList[FindPrime.nextPrime(size)];
        for(int i = 0; i < chainList.length; i++){
            chainList[i] = new LinkedList<Type>();
        }
        
    }
    
    public void insert(Type item){
        List<Type> whichList = chainList[hash(item)];
        if(!whichList.contains(item)){
            whichList.add(item);
            
            if(++nmbrItems > chainList.length){
                rehash();
            }
        }
    }
    
    public boolean find(Type item){
        List<Type> whichList = chainList[hash(item)];
        return whichList.contains(item);
    }
    
    private int hash(Type item){
        int hashVal = item.hashCode();
        
        hashVal %=chainList.length;
        if(hashVal < 0){
            hashVal +=chainList.length;
        }
        
        return hashVal;
    }
    
    private void rehash(){
        List<Type>[] oldLists = chainList;
        
        //new doubly sized seperate table
        chainList = new LinkedList[ FindPrime.nextPrime(2*chainList.length)];
        for(int j=0;j<chainList.length;j++){
           chainList[j]= new LinkedList<Type>();           
        }
        
        //Copy data to new list
        nmbrItems=0;
        for(int i = 0; i<oldLists.length;i++ ){
            for(Type item : oldLists[i])
                insert(item);
        }
    }
    
    
}
