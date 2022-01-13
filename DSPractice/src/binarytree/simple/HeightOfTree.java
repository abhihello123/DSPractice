package binarytree.simple;

import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class HeightOfTree {

    public static void main(String[] args) {
        BTreeNode root = BTreeNode.getDemoTree();
        //int height = findHeight(root);
        int height = findHeightWithoutRecursion(root);
        System.out.println("Height == " + height);
    }

    private static int findHeight(BTreeNode<Integer> root) {
        if (root == null)
            return 0;
        int leftSubtreeHeight = findHeight(root.left());
        int rightSubtreeHeight = findHeight(root.right());
        int max = leftSubtreeHeight;
        if (rightSubtreeHeight > leftSubtreeHeight)
            max = rightSubtreeHeight;
        return max + 1;
    }

    private static int findHeightWithoutRecursion(BTreeNode<Integer> root) {
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int count = 0;
        while(!queue.isEmpty()) {
            BTreeNode<Integer> element = queue.poll();
            if (element != null) {
                if (element.left()!=null)
                    queue.add(element.left());
                if (element.right()!=null)
                    queue.add(element.right());
            } else {
                count++;
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
        return count;
    }



}
