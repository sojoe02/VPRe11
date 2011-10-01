/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.hashing;

import interfaces.Constants;

/**
 *
 * @author sojoe
 */
public class QuadraticProbing<AnyType> implements Constants {
    
    private HashEntry<AnyType>[] array; // The array of elements
    private int currentSize;              // The number of occupied cells

    /**
     * Construct the hash table.
     */
    public QuadraticProbing() {
        this(DEFAULT_TABLE_SIZE);
    }

    /**
     * Construct the hash table.
     * @param size the approximate initial size.
     */
    public QuadraticProbing(int size) {
        allocateArray(size);
        makeEmpty();
    }

    /**
     * Make the hash table logically empty.
     */
    public void makeEmpty() {
        currentSize = 0;
        for (int i = 0; i < array.length; i++) {
            array[ i] = null;
        }
    }

    /**
     * Internal method to allocate array.
     * @param arraySize the size of the array.
     */
    private void allocateArray(int arraySize) {
        array = new HashEntry[arraySize];
    }

    /**
     * Find an item in the hash table.
     * @param x the item to search for.
     * @return the matching item.
     */
    public boolean contains(AnyType x) {
        int currentPos = findPos(x);
        return isActive(currentPos);
    }

    /**
     * Method that performs quadratic probing resolution.
     * @param x the item to search for.
     * @return the position where the search terminates.
     */
    private int findPos(AnyType x) {
        int offset = 1;
        int currentPos = hash(x.toString(), array.length);

        while (array[ currentPos] != null
                && !array[ currentPos].element.equals(x)) {
            currentPos += offset;  // Compute ith probe
            offset += 2;
            if (currentPos >= array.length) {
                currentPos -= array.length;
            }
        }

        return currentPos;
    }

    /**
     * Return true if currentPos exists and is active.
     * @param currentPos the result of a call to findPos.
     * @return true if currentPos is active.
     */
    private boolean isActive(int currentPos) {
        return array[ currentPos] != null && array[ currentPos].isActive;
    }

    /**
     * Insert into the hash table. If the item is
     * already present, do nothing.
     * @param x the item to insert.
     */
    public void insert(AnyType x) {
        // Insert x as active
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            return;
        }

        array[ currentPos] = new HashEntry<AnyType>(x, true);

        // Rehash; see Section 5.5
        if (++currentSize > array.length / 2) {
            rehash();
        }
    }

    /**
     * Remove from the hash table.
     * @param x the item to remove.
     */
    public void remove(AnyType x) {
        int currentPos = findPos(x);
        if (isActive(currentPos)) {
            array[ currentPos].isActive = false;
        }
    }

    public static class HashEntry<AnyType> {

        public AnyType element;  // the element
        public boolean isActive;  // false if marked deleted

        public HashEntry(AnyType e) {
            this(e, true);
        }

        public HashEntry(AnyType e, boolean i) {
            element = e;
            isActive = i;
        }

        @Override
        public String toString() {
            return (String) element;
        }
    }

    /**
     * Rehashing for quadratic probing hash table.
     */
    private void rehash() {
        HashEntry<AnyType>[] oldArray = array;

        // Create a new double-sized, empty table
        allocateArray(nextPrime(2 * oldArray.length));
        currentSize = 0;

        // Copy table over
        for (int i = 0; i < oldArray.length; i++) {
            if (oldArray[ i] != null && oldArray[ i].isActive) {
                insert(oldArray[ i].element);
            }
        }
    }

    private int myhash(AnyType x) {
        return (int) (Math.random() * currentSize);
    }

    public static int hash(String key, int tableSize) {
        int hashVal = 0;

        for (int i = 0; i < key.length(); i++) {
            hashVal = 37 * hashVal + key.charAt(i);
        }

        hashVal %= tableSize;
        if (hashVal < 0) {
            hashVal += tableSize;
        }
        System.out.println(hashVal);
        return hashVal;
    }

    public HashEntry getPos(int pos) {
        return array[pos];
    }

    private static int nextPrime(int n) {
        if (n % 2 == 0) {
            n++;
        }

        for (; !isPrime(n); n += 2);

        return n;
    }

    /**
     * Internal method to test if a number is prime.
     * Not an efficient algorithm.
     * @param n the number to test.
     * @return the result of the test.
     */
    private static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        }

        if (n == 1 || n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}
