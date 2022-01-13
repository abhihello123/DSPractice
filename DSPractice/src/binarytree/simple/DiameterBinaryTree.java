package binarytree.simple;

import binarytree.common.BTreeNode;
import binarytree.common.BTreePrinter;

public class DiameterBinaryTree {

    int maxDiameter = 1;

    public static void main(String[] args) {
        DiameterBinaryTree obj = new DiameterBinaryTree();
        BTreeNode<Integer> demoTreeRoot = BTreeNode.getBST();
        BTreePrinter.printNode(demoTreeRoot);
        obj.findMaxLevel(demoTreeRoot);
        System.out.println(obj.maxDiameter);
    }

    private int findMaxLevel(BTreeNode<Integer> root) {
        if (root.left() == null && root.right() == null) return 1;
        int leftLevel=0, rightLevel=0;
        if (root.left() != null) leftLevel = findMaxLevel(root.left());
        if (root.right() != null) rightLevel = findMaxLevel(root.right());
        int diameter = leftLevel + rightLevel + 1;
        maxDiameter = Integer.max(diameter, maxDiameter);
        return Integer.max(leftLevel, rightLevel) + 1 ;
    }

}
