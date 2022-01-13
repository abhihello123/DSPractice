package ll;

class LinkedList<T> {
    static class Node {
        int data;
        Node next;
        Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    Node head;

    Node removeNodeFromEnd(int k) {
        // Code here..
        if (k <= 0) throw new RuntimeException("k cannot be 0 or negative integer");

        Node p1 = this.head;
        Node p2 = this.head;
        Node prev = this.head;

        for (int i=0; i< k; i++) {
            if (p2 == null) {
                throw new RuntimeException("Cannot delete kth element as k > size of the list");
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }

        if (p1 == this.head) {
            if (p1 == prev && k ==1) {
                this.head = null;
                return p1;
            }
        }

        while (prev.next != p1) prev = prev.next;

        prev.next = p1.next;
        return p1;
    }

    public static void main(String[] args) {
        LinkedList<Node> sll = new LinkedList<Node>();
        //TC1
        sll.removeNodeFromEnd(1); // Not possible

        //TC2
        Node n1 = new Node(10, null);
        sll.head = n1;
        sll.removeNodeFromEnd(1); // Returns Node(10, null) => head = null

        //TC3
        n1 = new Node(10, null);
        sll.head = n1;
        Node n2 = new Node(20, null);
        n1.next = n2;
        sll.removeNodeFromEnd(2); // Returns Node(10, null) => head -> 20 -> null

        //TC4
        n1 = new Node(10, null);
        sll.head = n1;
        n2 = new Node(20, null);
        n1.next = n2;
        Node n3 = new Node(30, null);
        Node n4 = new Node(40, null);
        n2.next= n3;
        n3.next = n4;
        sll.removeNodeFromEnd(3); // Returns Node(20, null) => head -> 10 -> 30 -> 40 -> null


    }
}