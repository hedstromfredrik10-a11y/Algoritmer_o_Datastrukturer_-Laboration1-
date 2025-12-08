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
            size++;
            return new TreeNode(node);
        }

        if (node.compareTo(root.element) < 0) {
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
        if (root == null) {
            return null;
        }

        if (node.compareTo(root.element) == 0) {

            return root.element;
        } else if (node.compareTo(root.element) < 0) {
            return searchElementHelper(root.left, node);
        } else {
            return searchElementHelper(root.right, node);
        }

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inOrderTraversal(root, sb);
        return sb.toString().trim();
    }

    private void inOrderTraversal(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, sb);
        sb.append(node.element).append(" ");
        inOrderTraversal(node.right, sb);
    }

}