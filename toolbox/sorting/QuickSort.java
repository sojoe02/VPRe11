/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.sorting;

/**
 *
 * @author Zagadka
 */
public class QuickSort {

    /**
     * Internal quicksort method that makes recursive calls.
     * Uses median-of-three partitioning and a cutoff of 10.
     * @param a an array of Comparable items.
     * @param left the left-most index of the subarray.
     * @param right the right-most index of the subarray.
     */
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right, int cutoff) {
        if (left + cutoff <= right) {
            AnyType pivot = median3(a, left, right);
            //AnyType pivot = first(a, left, right) ;
            //AnyType pivot = distinct(a, left, right) ;
            // Begin partitioning
            int i = left, j = right - 1;
            for (;;) {
                while (a[ ++i].compareTo(pivot) < 0) {
                }
                while (a[ --j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }

            swapReferences(a, i, right - 1);   // Restore pivot

            quicksort(a, left, i - 1, cutoff);    // Sort small elements
            quicksort(a, i + 1, right, cutoff);   // Sort large elements
        } else // Do an insertion sort on the subarray
        {
            InsertionSort.insertionSort(a, left, right);
        }
    }

    /*
     * Same as above just with a default cutoff of 10
     */
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int left, int right) {
        if (left + 3 <= right) {
            AnyType pivot = median3(a, left, right);


            // Begin partitioning
            int i = left, j = right - 1;
            for (;;) {
                while (a[ ++i].compareTo(pivot) < 0) {
                }
                while (a[ --j].compareTo(pivot) > 0) {
                }
                if (i < j) {
                    swapReferences(a, i, j);
                } else {
                    break;
                }
            }
            swapReferences(a, i, right - 1);   // Restore pivot

            quicksort(a, left, i - 1);    // Sort small elements
            quicksort(a, i + 1, right);   // Sort large elements
        } else // Do an insertion sort on the subarray
        {
            InsertionSort.insertionSort(a, left, right);
        }
    }

    //launch default quicksort with just an array:
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a) {
        quicksort(a, 0, a.length - 1);
    }

    //launch default quicksort with array and cutoff argument:
    public static <AnyType extends Comparable<? super AnyType>> void quicksort(AnyType[] a, int cutoff) {
        quicksort(a, 0, a.length - 1, cutoff);
    }

    private static <AnyType extends Comparable<? super AnyType>> void swapReferences(AnyType[] a, int i, int j) {
        AnyType tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    /**
     * Return median of left, center, and right.
     * Order these and hide the pivot.
     */
    private static <AnyType extends Comparable<? super AnyType>> AnyType median3(AnyType[] a, int left, int right) {
        int center = (left + right) / 2;
        if (a[ center].compareTo(a[ left]) < 0) {
            swapReferences(a, left, center);
        }
        if (a[ right].compareTo(a[ left]) < 0) {
            swapReferences(a, left, right);
        }
        if (a[ right].compareTo(a[ center]) < 0) {
            swapReferences(a, center, right);
        }
        // Place pivot at position right - 1
        swapReferences(a, center, right - 1);
        return a[ right - 1];
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType first(AnyType[] a, int left, int right) {
        return a[left+1];
    }

    private static <AnyType extends Comparable<? super AnyType>> AnyType distinct(AnyType[] a, int left, int right) {
        
        //look for distint elements:
        for(int i = 1; i< right-left-1; i++){
            //return the biggest:
            if(a[left+i].compareTo(a[left+1+i])>0){
                return a[left+i];
            }
            if(a[left+i].compareTo(a[left+1+i])<0){
                return a[left+i+1];
            }
        }        
        //if there are none then just return one of them (they are all the same).
        return a[left];     
        
    }
}