/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // Create a dummy node to handle edge cases where the reverse starts from the first node
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prev = dummy;
        ListNode current = head;

        // Move prev and current pointers to the appropriate positions
        for (int i = 1; i < left; i++) {
            prev = prev.next;
            current = current.next;
        }

        ListNode subHead=current;
        ListNode prevNode=null;
        // Reverse the sublist
        for (int i = 0; i <= right - left; i++) {
            ListNode nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
        }
        prev.next=prevNode;
        subHead.next=current;

        return dummy.next;
    }
}