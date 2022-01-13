package binarytree.simple;

import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class FindIfTwoBTreesAreIdentical {

    public static void main(String[] args) {
        BTreeNode root1= BTreeNode.getDemoTree();
        BTreeNode root2 = BTreeNode.getDemoTree();
        BTreeNode<Integer> deepestNode = findIfIdenticalTrees(root1, root2);
        System.out.println("deepestNode == " + deepestNode.data());
    }

    private static BTreeNode<Integer> findIfIdenticalTrees(BTreeNode<Integer> root1, BTreeNode<Integer> root2) {
        return null;
    }

    }
