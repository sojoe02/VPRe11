/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.trees;


import java.util.LinkedList;

/**
 *
 * @author sojoe
 */
public class Traversal {

    public static void DFSPostOrder(AvlNode node) {
        if (node.left != null) {
            DFSPostOrder(node.left);
        }
        if (node.right != null) {
            DFSPostOrder(node.right);
        }
        System.out.print(node+", ");
    }

    public static void DFSPostOrder(AvlNode node, boolean print) {
        if (node.left != null) {
            DFSPostOrder(node.left, print);
        }
        if (node.right != null) {
            DFSPostOrder(node.right, print);
        }
        if (print == true) {
            System.out.print(node+", ");
        }
    }

    public static void DFSInOrder(AvlNode node) {
        if (node.left != null) {
            DFSInOrder(node.left);
        }
        System.out.print(node+", ");
        if (node.right != null) {
            DFSInOrder(node.right);
        }
    }

    public static void DFSInOrder(AvlNode node, boolean print) {
        if (node.left != null) {
            DFSInOrder(node.left, print);
        }
        if (print == true) {
            System.out.print(node+", ");
        }
        if (node.right != null) {
            DFSInOrder(node.right, print);
        }
    }

    public static void BFS(AvlNode node) {
        LinkedList<AvlNode> activeNodes = new LinkedList<AvlNode>();
        activeNodes.add(node);
        while (!activeNodes.isEmpty()) {
            AvlNode active = activeNodes.getLast();
            activeNodes.removeLast();
            System.out.print(active+", ");

            if (active.left != null) {
                activeNodes.addFirst(active.left);
            }
            if (active.right != null) {
                activeNodes.addFirst(active.right);
            }

        }
    }

    public static void BFS(AvlNode node, boolean print) {
        LinkedList<AvlNode> activeNodes = new LinkedList<AvlNode>();
        activeNodes.add(node);
        while (!activeNodes.isEmpty()) {
            AvlNode active = activeNodes.getLast();
            activeNodes.removeLast();
            if (print == true) {
                System.out.print(active+", ");
            }
            if (active.left != null) {
                activeNodes.addFirst(active.left);
            }
            if (active.right != null) {
                activeNodes.addFirst(active.right);
            }

        }
    }

    public static int nodeCount(AvlNode node) {
        LinkedList<AvlNode> activeNodes = new LinkedList<AvlNode>();
        int nodeCount = 0;
        activeNodes.add(node);
        while (!activeNodes.isEmpty()) {
            AvlNode active = activeNodes.getLast();
            activeNodes.removeLast();
            if (active.left != null || active.right != null) {
                nodeCount++;
            }
            if (active.left != null) {
                activeNodes.addFirst(active.left);
            }
            if (active.right != null) {
                activeNodes.addFirst(active.right);
            }
        }
        return nodeCount;
    }

    public static int fullNodeCount(AvlNode node) {
        LinkedList<AvlNode> activeNodes = new LinkedList<AvlNode>();
        int fullNodeCount = 0;
        activeNodes.add(node);
        while (!activeNodes.isEmpty()) {
            AvlNode active = activeNodes.getLast();
            activeNodes.removeLast();
            if (active.left != null && active.right != null) {
                fullNodeCount++;
            }
            if (active.left != null) {
                activeNodes.addFirst(active.left);
            }
            if (active.right != null) {
                activeNodes.addFirst(active.right);
            }
        }
        return fullNodeCount;
    }

    public static int leafNodeCount(AvlNode node) {
        LinkedList<AvlNode> activeNodes = new LinkedList<AvlNode>();
        int leafCount = 0;
        activeNodes.add(node);
        while (!activeNodes.isEmpty()) {
            AvlNode active = activeNodes.getLast();
            activeNodes.removeLast();
            if (active.left == null && active.right == null) {
                leafCount++;
            }
            if (active.left != null) {
                activeNodes.addFirst(active.left);
            }
            if (active.right != null) {
                activeNodes.addFirst(active.right);
            }
        }
        return leafCount;
    }
}
