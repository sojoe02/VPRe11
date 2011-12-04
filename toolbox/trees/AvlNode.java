/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package toolbox.trees;

/**
 *
 * @author sojoe
 */
public class AvlNode<AnyType> {
    AnyType element;      // The data in the node
    AvlNode<AnyType> left;         // Left child
    AvlNode<AnyType> right;        // Right child
    int height;       // Height

    public AvlNode(AnyType theElement) {
        this(theElement, null, null);
    }

    public AvlNode(AnyType theElement, AvlNode<AnyType> lt, AvlNode<AnyType> rt) {
        element = theElement;
        left = lt;
        right = rt;
        height = 0;
    }

    @Override
    public String toString() {
        return this.element.toString();
    }
}
