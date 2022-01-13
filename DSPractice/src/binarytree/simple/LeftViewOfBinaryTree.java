package binarytree.simple;

import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBinaryTree {

    private int max_level = -1;

    public static void main(String[] args) {
        LeftViewOfBinaryTree obj = new LeftViewOfBinaryTree();
        BTreeNode<Integer> demoTreeRoot = BTreeNode.getDemoTree();
        //obj.leftViewUsingLevelOrder(demoTreeRoot);
        obj.leftViewUsingPreOrder(demoTreeRoot, 0);
    }

    /**
     * Uses Level Order Traversal
     */
    private void leftViewUsingLevelOrder(BTreeNode<Integer> root) {
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root); queue.add(null);
        BTreeNode<Integer> temp;
        BTreeNode<Integer> leftEle;
        while (!queue.isEmpty() && (leftEle = queue.peek()) != null) {
            System.out.println(leftEle.data());
            while ((temp = queue.remove()) != null) {
                if (temp.left() != null) queue.add(temp.left());
                if (temp.right() != null) queue.add(temp.right());
            }
            queue.add(null);
        }
    }

    /**
     * Uses Pre Order Traversal
     */
    private void leftViewUsingPreOrder(BTreeNode<Integer> root, int level) {
        if (level > max_level) {
            System.out.println(root.data());
            max_level = level;
        }
        if (root.left() != null) leftViewUsingPreOrder(root.left(), level+1);
        if (root.right() != null) leftViewUsingPreOrder(root.right(), level+1);
    }

}
