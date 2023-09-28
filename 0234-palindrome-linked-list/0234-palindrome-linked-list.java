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
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        ListNode slow = head, fast = head, rev = null;
        while (fast != null && fast.next != null) {
            ListNode temp = rev;
            rev = slow;
            slow = slow.next;
            fast = fast.next.next;
            rev.next = temp;
        }
        ListNode tail = fast != null ? slow.next : slow;
        while (rev != null) {
            if (tail.val != rev.val) {
                return false;
            }
            ListNode temp = slow;
            slow = rev;
            tail = tail.next;
            rev = rev.next;
            slow.next = temp;
        }
        return true;
    }
}