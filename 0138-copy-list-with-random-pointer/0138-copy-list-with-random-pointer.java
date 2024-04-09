/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        
        if (head == null)
            return null;

        // Step 1: Create a copy of each node and insert it next to its original node
        Node temp = head;
        while (temp != null) {
            Node copy = new Node(temp.val);
            copy.next = temp.next;
            temp.next = copy;
            temp = copy.next;
        }

        // Step 2: Set random pointers for the copied nodes
        temp = head;
        while (temp != null) {
            if (temp.random != null)
                temp.next.random = temp.random.next; // Point copied node's random to copied random node
            temp = temp.next.next;
        }

        // Step 3: Separate the original and copied lists
        temp = head;
        Node newHead = head.next; // Head of the copied list
        Node copiedTemp = newHead;

        while (temp != null) {
            temp.next = copiedTemp.next;
            temp = temp.next;
            if (temp != null) {
                copiedTemp.next = temp.next;
                copiedTemp = copiedTemp.next;
            }
        }

        return newHead;
    }
}