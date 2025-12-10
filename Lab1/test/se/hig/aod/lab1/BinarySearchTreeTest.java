package Lab1.test.se.hig.aod.lab1;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import se.hig.aod.lab1.BinarySearchTree;

/**
 * Unit tests for the BinarySearchTree class.
 */

public class BinarySearchTreeTest {
    private BinarySearchTree<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BinarySearchTree<>();
    }

    @Test
    public void testSizeInitiallyZero() {
        assertEquals(0, bst.size());

    }

    @Test
    public void testSize() {
        bst.addElement(50);
        assertEquals(1, bst.size());

        bst.addElement(10);
        bst.addElement(30);

        assertEquals(3, bst.size());
    }

    @Test
    public void testSearchElement() {
        bst.addElement(10);
        bst.addElement(15);
        bst.addElement(20);

        assertEquals(10, bst.searchElement(10));
        assertEquals(15, bst.searchElement(15));
        assertEquals(20, bst.searchElement(20));

        assertNull(bst.searchElement(100));
        assertNull(bst.searchElement(-15));
        assertNull(bst.searchElement(-1512));
    }

    @Test
    public void testInorderTraversalSortedOrder() {
        bst.addElement(50);
        bst.addElement(30);
        bst.addElement(70);
        bst.addElement(20);
        bst.addElement(40);
        bst.addElement(60);
        bst.addElement(80);

        assertEquals("20 30 40 50 60 70 80", bst.toString());
    }

    @Test
    public void testEmptyToString() {
        assertEquals("", bst.toString());
    }

}
