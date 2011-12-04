/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package press;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import toolbox.sorting.InsertionSort;
import toolbox.sorting.QuickSort;
import java.util.Random;

/**
 *
 * @author Zagadka
 */
public class Sort {

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int size = 100000;

        Integer[] sort = new Integer[size];
        Integer[] isort = new Integer[size];
        Integer[] jsort = new Integer[size];

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomInt = random.nextInt(size * 10);
            sort[i] = randomInt;
            isort[i] = randomInt;
            jsort[i] = randomInt;
        }

        System.out.println(" ");
        System.out.println("testing sort:");
        //read system nanotime to get as precise a reading as possible.        
        System.out.println("Quick Sort:");
        long testtime = System.nanoTime();
        QuickSort.quicksort(sort, 10);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

//        System.out.println("Insertion Sort:");
//        testtime = System.nanoTime();
//        InsertionSort.insertionSort(isort);
//        testtime = System.nanoTime() - testtime;
//        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

        System.out.println("Javas own Sort:");
        testtime = System.nanoTime();
        Arrays.sort(jsort);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

//        for (int i = 0; i < sort.length; i++) {
//            System.out.print(jsort[i] + ",");
//        }
        silentTestingDiffSort(10, size);
        //silentTestingSorted(10,size);
        //silentTestingReverse(10, size);

    }

    /*
     * Function to to some silent testing and then write the timing results into
     * a comma seperated file (csv) for plotting purposes.
     * 
     * @param iteratorvalue=number of iterations, then the three different 
     * hashsets and the arraylist
     */
    private static void silentTestingDiffSort(int iteratorValue, int size) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        long testtime = 0;
        Integer[] sort = new Integer[size];
//        Integer[] isort = new Integer[size];
//        Integer[] jsort = new Integer[size];
        System.out.println(size);

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test3a.csv"));
            for (int i = 0; i < iteratorValue; i++) {

                //Random random = new Random();

                for (int j = 0; j < size; j++) {
                    //int randomInt = random.nextInt(10 * size);
                    sort[j] = size-j;//randomInt;
//                    isort[j] = randomInt;
//                    jsort[j] = randomInt;
                }

//                testtime = System.nanoTime();
//                InsertionSort.insertionSort(isort);
//                testtime = System.nanoTime() - testtime;
//
//                out.write(Long.toString(testtime / 1000000) + "." + Long.toString(testtime % 1000000) + ",");

                testtime = System.nanoTime();
                QuickSort.quicksort(sort, 10);
                testtime = System.nanoTime() - testtime;
//
//                out.write(Long.toString(testtime / 1000000) + "." + Long.toString(testtime % 1000000) + ",");
//
//                testtime = System.nanoTime();
//                Arrays.sort(jsort);
//                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000));


                out.newLine();
            }
            out.close();

        } catch (IOException e) {
        }

    }

    private static void silentTestingSorted(int iteratorValue, int size) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        long testtime = 0;
        Integer[] sort = new Integer[size];
        Integer[] isort = new Integer[size];
        Integer[] jsort = new Integer[size];

       
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test3b.csv"));
            for (int i = 0; i < iteratorValue; i++) {

                for (int j = 0; j < size; j++) {
                    sort[j] = j;
                    isort[j] = j;
                    jsort[j] = j;
                }

                testtime = System.nanoTime();
                InsertionSort.insertionSort(isort);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000) + ";");

                testtime = System.nanoTime();
                QuickSort.quicksort(sort, 10);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000) + ";");

                testtime = System.nanoTime();
                Arrays.sort(jsort);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000));



                out.newLine();
            }
            out.close();

        } catch (IOException e) {
        }

    }

    private static void silentTestingReverse(int iteratorValue, int size) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        long testtime = 0;
        Integer[] sort = new Integer[size];
        Integer[] isort = new Integer[size];
        Integer[] jsort = new Integer[size];

       
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test3c.csv"));
            for (int i = 0; i < iteratorValue; i++) {

                for (int j = 0; j < size; j++) {
                    sort[j] = size-j;
                    isort[j] = size-j;
                    jsort[j] = size-j;
                }

                testtime = System.nanoTime();
                InsertionSort.insertionSort(isort);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000) + ";");

                testtime = System.nanoTime();
                QuickSort.quicksort(sort, 10);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000) + ";");

                testtime = System.nanoTime();
                Arrays.sort(jsort);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime / 1000000) + "," + Long.toString(testtime % 1000000));



                out.newLine();
            }
            out.close();

        } catch (IOException e) {
        }

    }
}
