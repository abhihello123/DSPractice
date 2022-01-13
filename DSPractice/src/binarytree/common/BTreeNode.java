package binarytree.common;

/**
 * Created by Abhisek on 07-Oct-19.
 */
public class BTreeNode<T extends Comparable<?>> {

    private T data;
    private BTreeNode<T> left;
    private BTreeNode<T> right;

    public BTreeNode(T data) {
        this.data = data;
    }

    public T data() {
        return data;
    }

    public BTreeNode<T> left() {
        return left;
    }

    public BTreeNode<T> right() {
        return right;
    }

    public void setLeft(BTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BTreeNode<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static BTreeNode<Integer> getDemoTree() {
        BTreeNode<Integer> root = new BTreeNode<>(1);
        BTreeNode<Integer> two = new BTreeNode<>(2);
        BTreeNode<Integer> three = new BTreeNode<>(3);
        BTreeNode<Integer> four = new BTreeNode<>(4);
        BTreeNode<Integer> five = new BTreeNode<>(5);
        BTreeNode<Integer> six = new BTreeNode<>(6);
        BTreeNode<Integer> seven = new BTreeNode<>(7);
        root.setLeft(two);
        root.setRight(three);
        two.setLeft(four);
        two.setRight(five);
        three.setLeft(six);
        five.setRight(seven);
        return root;
    }

    public static BTreeNode<Integer> getBST() {
        BTreeNode<Integer> root = new BTreeNode<>(8);
        BTreeNode<Integer> five = new BTreeNode<>(5);
        BTreeNode<Integer> four = new BTreeNode<>(4);
        BTreeNode<Integer> six = new BTreeNode<>(6);
        BTreeNode<Integer> twelve = new BTreeNode<>(12);
        BTreeNode<Integer> ten = new BTreeNode<>(10);
        BTreeNode<Integer> sixTeen = new BTreeNode<>(16);
        root.setLeft(five);
        root.setRight(twelve);
        five.setLeft(four);
        five.setRight(six);
        twelve.setLeft(ten);
        twelve.setRight(sixTeen);
        return root;
    }



    public static <X extends Comparable<?>> void printTree(BTreeNode<X> root) {
        BTreePrinter.printNode(root);
    }

/*    public static void main(String[] args) {
        BTreeNode<Integer> root = getDemoTree();
        BTreeNode.printTree(root);
    }*/

}
