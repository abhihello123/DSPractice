package binarytree.simple;

import binarytree.common.BTreeNode;

/**
 * Child Nodes have to be deleted before deleting the parent node
 * Prefer using PostOrderTraversal as Root Node is visited after visiting left and right subtrees
 * Other orders including level order can also delete the tree but requires extra memory
 */
public class DeleteTree {

    public static void main(String[] args) {
        BTreeNode<Integer> root = BTreeNode.getDemoTree();
        deleteTree(root);
    }

    private static void deleteTree(BTreeNode<Integer> root) {
        if (root == null)
            return;
        deleteTree(root.left());
        deleteTree(root.right());
        System.out.println("deleting node: " + root.data());
        root = null;
    }

}
