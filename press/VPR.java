/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package press;

import java.io.File;
import java.util.ArrayList;
import toolbox.Search;
import toolbox.hashing.QuadraticProbing;
import toolbox.hashing.SeperateChaining;
/**
 *
 * @author sojoe
 */
public class VPR {    

    public static void main(String args[]) {
        
        Search searcher = new Search(".pdf");  
        SeperateChaining chainHashing = new SeperateChaining<String>();
        QuadraticProbing quadHashing = new QuadraticProbing<String>();
        
        searcher.findFilTypeAntal(new File("/home/sojoe")); 
       
        System.out.println(searcher);
        
        //Get the searching paths in an array:
        ArrayList paths = searcher.getPaths();
        
        for(int i = 0; i <paths.size(); i++){
            chainHashing.insert(paths.get(i));
        }
        
        System.out.println(chainHashing.find("ARGLEGLAE"));
        
        long testtime=System.nanoTime();        
        testtime = System.nanoTime()-testtime;
        System.out.println(chainHashing.find("/home/sojoe/Documents/EMB1/Suggested_reading/AN-340.pdf"));
        System.out.println(testtime);        
        
        
        
        testtime=System.nanoTime();
        System.out.println(paths.contains("/home/sojoe/Documents/EMB1/Suggested_reading/AN-340.pdf"));
        testtime = System.nanoTime()-testtime;
        System.out.println(testtime);       
        
    }    
    
}
