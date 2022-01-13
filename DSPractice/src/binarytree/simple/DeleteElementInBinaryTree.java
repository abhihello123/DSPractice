package binarytree.simple;


import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class DeleteElementInBinaryTree {

    public static void main(String[] args) {
        BTreeNode<Integer> root = BTreeNode.getDemoTree();
        System.out.println("Original Tree :---");
        BTreeNode.printTree(root);
        int dataToBeDeleted = 2;
        BTreeNode<Integer> deepestNode = findDeepestNodeAndReplaceDeletedNodeData(root, dataToBeDeleted);
        removeDeepestNode(root, deepestNode);
        System.out.println("After Deletion :---");
        BTreeNode.printTree(root);
    }

    /*
    Remove the deepest node
     */
    private static void removeDeepestNode(BTreeNode<Integer> root, BTreeNode<Integer> deepestNode) {
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        BTreeNode<Integer> tempNode;
        while (!queue.isEmpty()) {
            tempNode = queue.poll();
            if (tempNode.left() != null) {
                queue.add(tempNode.left());
                if(tempNode.left() == deepestNode)
                    tempNode.setLeft(null);
            }
            if (tempNode.right() != null) {
                queue.add(tempNode.right());
                if(tempNode.right() == deepestNode)
                    tempNode.setRight(null);
            }
        }
    }

    /*
    Find deepest node and replace its data with the node being deleted
     */
    private static BTreeNode<Integer> findDeepestNodeAndReplaceDeletedNodeData(BTreeNode<Integer> root, int dataToBeDeleted) {
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        BTreeNode<Integer> deepestNode = root;
        boolean isFound = false;
        BTreeNode<Integer> nodeToBeDeleted = null;
        while (!queue.isEmpty()) {
            deepestNode = queue.poll();
            if (!isFound && deepestNode.data() == dataToBeDeleted) {
                nodeToBeDeleted = deepestNode;
                isFound = true;
            }
            if (deepestNode.left() != null)
                queue.add(deepestNode.left());
            if (deepestNode.right() != null)
                queue.add(deepestNode.right());
        }
        nodeToBeDeleted.setData(deepestNode.data());
        return deepestNode;
    }

}
