/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package press;

import java.util.Arrays;
import toolbox.sorting.InsertionSort;
import toolbox.sorting.QuickSort;
import java.util.Random;

/**
 *
 * @author Zagadka
 */
public class Search {

    public static void main(String args[]) {
        final int SIZE = 100000;

        Integer[] sort = new Integer[SIZE];
        Integer[] isort = new Integer[SIZE];
        Integer[] jsort = new Integer[SIZE];

        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            int randomInt = random.nextInt(2000000);
            sort[i] = randomInt;
            isort[i] = randomInt;
            jsort[i] = randomInt;
        }



//        for (int i = 0; i < sort.length; i++) {
//            System.out.print(sort[i] + ",");
//        }

        System.out.println(" ");
        System.out.println("testing sort");
        //read system nanotime to get as precise a reading as possible.        
        long testtime = System.nanoTime();
        QuickSort.quicksort(sort, 10);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

//               for (int i = 0; i < sort.length; i++) {
//            System.out.print(sort[i] + ",");
//        }
        testtime = System.nanoTime();
        InsertionSort.insertionSort(isort);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

        testtime = System.nanoTime();
        Arrays.sort(jsort);
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

//        for (int i = 0; i < sort.length; i++) {
//            System.out.print(jsort[i] + ",");
//        }




    }
}
