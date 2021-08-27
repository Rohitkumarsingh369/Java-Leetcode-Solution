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
    public ListNode swapNodes(ListNode head, int k) {
         ListNode curr = head;
        ListNode first = null;
        
        // Find first node
        
        for(int i = 0; i < k - 1; i++)
            curr = curr.next;
        
        first = curr;
        
        // Create window
        
        ListNode second = head;
        
        // Find second node
        
        while(curr.next != null) {
            curr = curr.next;
            second = second.next;
        }
        
        // Swap value
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
        return head;
    }
}