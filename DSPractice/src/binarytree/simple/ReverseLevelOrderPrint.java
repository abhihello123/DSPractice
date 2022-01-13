package binarytree.simple;

import binarytree.common.BTreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Abhishek on 08-Oct-19.
 */
public class ReverseLevelOrderPrint {

    public static void main(String[] args) {
        BTreeNode root = BTreeNode.getDemoTree();
        printReverseLevelOrder(root);
    }

    /*
    First add right then left
     */
    private static void printReverseLevelOrder(BTreeNode<Integer> root) {
        Stack<Integer> stack = new Stack<>();
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        stack.push(root.data());
        while (!queue.isEmpty()) {
            BTreeNode<Integer> element = queue.poll();
            if (element.right() != null) {
                stack.push(element.right().data());
                queue.add(element.right());
            }
            if (element.left() != null) {
                stack.push(element.left().data());
                queue.add(element.left());
            }
        }

        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }


/*
    private static void printReverseLevelOrder_inefficient(BTreeNode<Integer> root) {
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Queue<BTreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        while(!queue.isEmpty()) {
            BTreeNode<Integer> element = queue.poll();
            if (element != null) {
                stack2.add(element.data());
                if(element.left() != null)
                    queue.add(element.left());
                if(element.right() != null)
                    queue.add(element.right());
            } else {
                if (!queue.isEmpty())
                    queue.add(null);
                while(!stack2.isEmpty())
                    stack.push(stack2.pop());
            }
            //stack.add(element.data());

        }
        while(!stack.isEmpty())
            System.out.print(stack.pop()+" ");
    }
*/

}
