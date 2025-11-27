package se.hig.aod.lab1;

public class BinarySearchTree<T extends Comparable<? super T>> implements SearchableDataStructure<T> {

    class TreeNode {
        T element;
        TreeNode left;
        TreeNode right;

        public TreeNode(T element) {
            this.element = element;
        }
    }

    TreeNode root;
    int size = 0;

    @Override
    public int size() {
        
        return size;
    }

    @Override
    public void addElement(T newElement) {
        root = addElementHelper(root, newElement);
    }

    private TreeNode addElementHelper(TreeNode root, T node) {
        if (root == null) {
            return new TreeNode(node);
        } else if (node.compareTo(root.element) < 0) {
            root.left = addElementHelper(root.left, node);
        } else {
            root.right = addElementHelper(root.right, node);
        }

        return root;
    }

    @Override
    public T searchElement(T elementToFind) {
        return searchElementHelper(root, elementToFind);
    }

    private T searchElementHelper(TreeNode root, T node) {

        T data = node;

        if (node.compareTo(root.element) == 0) {
            return data;
        } else if (data.compareTo(root.element) < 0) {
            root.left = (TreeNode) searchElementHelper(root.left, node);
        } else if (data.compareTo(root.element) > 0) {
            root.right = (TreeNode) searchElementHelper(root.right, node);
        } else {
            data = null;
        }

        return data;

    }

}