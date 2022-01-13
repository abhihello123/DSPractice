package binarytree.simple;

import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class FindDeepestNodeOfBinaryTree {

    public static void main(String[] args) {
        BTreeNode root = BTreeNode.getDemoTree();
        BTreeNode<Integer> deepestNode = findDeepestNode(root);
        System.out.println("deepestNode == " + deepestNode.data());
    }

    private static BTreeNode<Integer> findDeepestNode(BTreeNode<Integer> root) {
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        BTreeNode<Integer> deepestNode = root;
        while (!queue.isEmpty()) {
            deepestNode = queue.poll();
            if (deepestNode.left() != null)
                queue.add(deepestNode.left());
            if (deepestNode.right() != null)
                queue.add(deepestNode.right());
        }
        return deepestNode;
    }

}
