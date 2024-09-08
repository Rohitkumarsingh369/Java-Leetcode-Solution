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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases
        dummy.next = head;
        ListNode prev = dummy; // Node before the sequence of duplicates
        ListNode current = head;

        while (current != null) {
            boolean hasDuplicates = false;

            // Check for duplicates
            while (current.next != null && current.val == current.next.val) {
                current = current.next;
                hasDuplicates = true;
            }

            if (hasDuplicates) {
                // Skip all duplicates
                prev.next = current.next;
            } else {
                // No duplicates, move prev
                prev = prev.next;
            }

            current = current.next;
        }

        return dummy.next; 
    }
}