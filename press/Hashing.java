/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package press;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import toolbox.SearchFileSystem;
import toolbox.hashing.QuadraticProbing;
import toolbox.hashing.SeperateChaining;

/**
 *
 * @author sojoe
 */
public class Hashing {

    public static void main(String args[]) throws FileNotFoundException {

        //Path to look for files.
        String testPath="";

        //if an argument of searchpath is given.
        if (args.length > 1) {
            testPath = args[1];
        }
        
        //Check of operating system linux or windows (havent bothered with mac):
        if (args.length == 0) {
            
            String os = System.getProperty("os.name").toLowerCase();
            
            if(os.indexOf( "win" ) >= 0){
               testPath="C://"; //c drive for windows
            }
            else if(os.indexOf( "nix") >=0 || os.indexOf( "nux") >=0){
               testPath=System.getProperty("user.home"); //homedir for nix user
            }
        }
        
        //the extensions to look for:
        String pattern[] = {".mp3", ".flac"};

        SearchFileSystem searcher = new SearchFileSystem(pattern);
        //Initialize the hashsets:
        SeperateChaining chainHashing = new SeperateChaining<String>();
        QuadraticProbing quadHashing = new QuadraticProbing<String>();
        
        //Start the search on the designated path:
        searcher.findFilTypeAntal(new File(testPath));
        
        //Print the searchers toString:
        System.out.println(searcher);

        //Get the searching paths in an array:
        ArrayList paths = searcher.getPaths();

        
        /*
         * Starting the testing, first is insertions.
         */
             
        System.out.println("Testing, time of insertion of the different methods.");

        System.out.print("Testing insertion of Seperate Chaining Hashing:\t");
        /*
         * First up is Seperate Chaining.
         */
        
        //read system nanotime to get as precise a reading as possible.        
        long testtime = System.nanoTime();
        
        for (int i = 0; i < paths.size(); i++) {
            chainHashing.insert(paths.get(i));
        }
        testtime = System.nanoTime() - testtime;

        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");


        /*
         * Test Quadratic insertion.
         */
        testtime = System.nanoTime();
        System.out.print("Testing insertion of Quadratic Hashing:\t\t");
        for (int i = 0; i < paths.size(); i++) {
            quadHashing.insert(paths.get(i));
        }
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");


        /*
         * Test hashSet:
         */
        testtime = System.nanoTime();
        System.out.print("Testing insertion of Javas HashSet:\t\t");
        Set hashSet = new HashSet<String>(paths);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

        /*
         * Test search times:  with random path in the result array       
         */
        
        Random generator = new Random();
        String testString = paths.get(generator.nextInt(paths.size())).toString();
        

        System.out.println("\nTesting, timing search of the different methods.");

        System.out.println("Test string is: " + testString + "\n");

        System.out.print("Testing Seperate Chaining Hashing:\t\t");
        testtime = System.nanoTime();
        if (chainHashing.find(testString)) {
            System.out.print("file found on:\t ");
        }
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime + " ns");

        System.out.print("Testing Quadratic Hashing:\t\t\t");
        testtime = System.nanoTime();
        if (quadHashing.contains(testString)) {
            System.out.print("file found on:\t ");
        }
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime + " ns");

        System.out.print("Testing Javas HashSet:\t\t\t\t");
        testtime = System.nanoTime();
        if (hashSet.contains(testString)) {
            System.out.print("file found on:\t ");
        }

        testtime = System.nanoTime() - testtime;
        System.out.println(testtime + " ns");

        System.out.print("Testing ArrayList (Javas implementation):\t");
        testtime = System.nanoTime();
        if (paths.contains(testString)) {
            System.out.print("file found on:\t ");
        }
        testtime = System.nanoTime() - testtime;

        System.out.println(testtime + " ns");
        try {
            silentTesting(10, chainHashing, quadHashing, hashSet, paths);
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Hashing.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    /*
     * Function to to some silent testing and then write the timing results into
     * a comma seperated file (csv) for plotting purposes.
     * 
     * @param iteratorvalue=number of iterations, then the three different 
     * hashsets and the arraylist
     */

    private static void silentTesting(int iteratorValue, SeperateChaining chainHashing,
            QuadraticProbing quadHashing, Set hashSet, ArrayList paths) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        long testtime = 0;
        Random generator = new Random();
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test.csv"));
            for (int i = 0; i < iteratorValue; i++) {
                String testString = paths.get(generator.nextInt(paths.size())).toString();
                

                testtime = System.nanoTime();
                chainHashing.find(testString);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                quadHashing.contains(testString);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                hashSet.contains(testString);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                paths.contains(testString);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime));
                out.newLine();
            }
            out.close();

        } catch (IOException e) {
        }

    }
}
