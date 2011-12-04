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
import java.util.Random;
import toolbox.trees.AvlTree;
import toolbox.trees.Traversal;

/**
 *
 * @author sojoe
 */
public class TreeTraversal {

    public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        int size = 100000;

        if (args.length > 1) {
            size = Integer.getInteger(args[1]);
        }

        AvlTree<Integer> tree = new AvlTree<Integer>();

        Random random = new Random();
        for (int i = 0; i < size; i++) {
            int randomInt = random.nextInt(10*size);
            tree.insert(randomInt);
        }

        System.out.println("Testing BFS");
        long testtimeBFS = System.nanoTime();
        Traversal.BFS(tree.getRoot());
        testtimeBFS = System.nanoTime() - testtimeBFS;
        long testtimeBFSno = System.nanoTime();
        Traversal.BFS(tree.getRoot(), false);
        testtimeBFSno = System.nanoTime() - testtimeBFSno;

        System.out.println("Testing DFS In Order:");
        long testtimeDFSinorder = System.nanoTime();
        Traversal.DFSInOrder(tree.getRoot());
        testtimeDFSinorder = System.nanoTime() - testtimeDFSinorder;

        long testtimeDFSinorderno = System.nanoTime();
        Traversal.DFSInOrder(tree.getRoot(), false);
        testtimeDFSinorderno = System.nanoTime() - testtimeDFSinorderno;


        System.out.println("Testing DFS Post Order:");
        long testtimeDFSpostorder = System.nanoTime();
        Traversal.DFSPostOrder(tree.getRoot());
        testtimeDFSpostorder = System.nanoTime() - testtimeDFSpostorder;

        long testtimeDFSpostorderno = System.nanoTime();
        Traversal.DFSPostOrder(tree.getRoot(), false);
        testtimeDFSpostorderno = System.nanoTime() - testtimeDFSpostorderno;

        System.out.println("\n\nResults:\n");
        System.out.println("Counting number of full Nodes:");
        long testtime = System.nanoTime();
        System.out.println(Traversal.fullNodeCount(tree.getRoot()));
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");


        System.out.println("Counting the number of leaf Nodes:");
        testtime = System.nanoTime();
        System.out.println(Traversal.leafNodeCount(tree.getRoot()));
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

        System.out.println("Counting the number of Nodes:");
        testtime = System.nanoTime();
        System.out.println(Traversal.nodeCount(tree.getRoot()));
        testtime = System.nanoTime() - testtime;
        System.out.println(testtime / 1000000 + "." + testtime % 1000000 + " ms");

        System.out.println("BFS time with printing nodes:");
        System.out.println(testtimeBFS / 1000000 + "." + testtimeBFS % 1000000 + " ms");
        System.out.println("BFS time with not printing nodes:");
        System.out.println(testtimeBFSno / 1000000 + "." + testtimeBFSno % 1000000 + " ms");


        System.out.println("DFS inorder time with printing nodes:");
        System.out.println(testtimeDFSinorder / 1000000 + "." + testtimeDFSinorder % 1000000 + " ms");
        System.out.println("DFS inorder time with not printing nodes:");
        System.out.println(testtimeDFSinorderno / 1000000 + "." + testtimeDFSinorderno % 1000000 + " ms");

        System.out.println("DFS postorder time with printing nodes:");
        System.out.println(testtimeDFSpostorder / 1000000 + "." + testtimeDFSpostorder % 1000000 + " ms");
        System.out.println("DFS postorder time with not printing nodes:");
        System.out.println(testtimeDFSpostorderno / 1000000 + "." + testtimeDFSpostorderno % 1000000 + " ms");

        silentTesting(100, size);
    }

    private static void silentTesting(int iteratorValue, int size) throws FileNotFoundException, UnsupportedEncodingException, IOException {
        long testtime = 0;
        Random random = new Random();


        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("test2.csv"));
            for (int i = 0; i < iteratorValue; i++) {

                AvlTree<Integer> tree = new AvlTree<Integer>();

                for (int j = 0; j < size; j++) {
                    int randomInt = random.nextInt(200000000);
                    tree.insert(randomInt);
                }

                testtime = System.nanoTime();
                Traversal.BFS(tree.getRoot(), false);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                Traversal.DFSInOrder(tree.getRoot(), false);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                Traversal.DFSPostOrder(tree.getRoot(), false);
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                Traversal.nodeCount(tree.getRoot());
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                Traversal.fullNodeCount(tree.getRoot());
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime) + ",");

                testtime = System.nanoTime();
                Traversal.leafNodeCount(tree.getRoot());
                testtime = System.nanoTime() - testtime;

                out.write(Long.toString(testtime));

                out.newLine();
            }
            out.close();

        } catch (IOException e) {
        }

    }
}
