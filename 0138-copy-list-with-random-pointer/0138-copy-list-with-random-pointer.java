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
        Node curr = head;
        while (curr != null) {
            Node copy = new Node(curr.val);
            copy.next = curr.next;
            curr.next = copy;
            curr = copy.next;
        }

        // Step 2: Set random pointers for the copied nodes
        curr = head;
        while (curr != null) {
            if (curr.random != null)
                curr.next.random = curr.random.next; // Point copied node's random to copied random node
            curr = curr.next.next;
        }

        // Step 3: Separate the original and copied lists
        curr = head;
        Node newHead = head.next; // Head of the copied list
        Node copiedCurr = newHead;

        while (curr != null) {
            curr.next = copiedCurr.next;
            curr = curr.next;
            if (curr != null) {
                copiedCurr.next = curr.next;
                copiedCurr = copiedCurr.next;
            }
        }

        return newHead;
    }
}