package binarytree.search.simple;

import binarytree.common.BTreeNode;

public class FindIfPresentInBinaryTree {

    public static void main(String[] args) {
        BTreeNode root = BTreeNode.getDemoTree();
        boolean isFound = findInBinaryTree(root, 88);
        System.out.println("Is Found == " + isFound);
    }

    private static boolean findInBinaryTree(BTreeNode<Integer> root, int element) {
        if (root == null)
            return false;
        if (root.data() == element) {
            return true;
        }
        if (findInBinaryTree(root.left(), element) || findInBinaryTree(root.right(), element)) {
            return true;
        } else {
            return false;
        }
    }



}
