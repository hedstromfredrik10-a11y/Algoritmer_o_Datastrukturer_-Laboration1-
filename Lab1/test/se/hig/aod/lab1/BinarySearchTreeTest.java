package Lab1.test.se.hig.aod.lab1;

import static org.junit.Assert.assertEquals;

import javax.swing.tree.TreeNode;

import org.junit.Test;

import se.hig.aod.lab1.BinarySearchTree;

public class BinarySearchTreeTest {

    BinarySearchTree tree = new BinarySearchTree<>();

    @Test
    public void addElementTest() {
        tree.addElement(5);
        tree.addElement(4);
        tree.addElement(8);
        tree.addElement(9);
        tree.addElement(1);
    }

    // @Test
    // public void searchElementTest() {
    // // tree.searchElement(8);
    // assertEquals(tree.searchElement(8), 8);
    // }
}
