package binarytree.simple;

import binarytree.common.BTreeNode;
import binarytree.common.BTreePrinter;

public class CheckBinaryTreeIsBst {

    public static void main(String[] args) {
        CheckBinaryTreeIsBst obj = new CheckBinaryTreeIsBst();
        BTreeNode<Integer> demoTreeRoot = BTreeNode.getBST();
        BTreePrinter.printNode(demoTreeRoot);
        System.out.println(obj.findBst(demoTreeRoot, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    private boolean findBst(BTreeNode<Integer> root, int min, int max) {
        if (root == null) return true;
        if (root.data() < min || root.data() > max)
            return false;
        else {
            return findBst(root.left(), min, root.data()) && findBst(root.right(), root.data(), max);
        }
    }

}
