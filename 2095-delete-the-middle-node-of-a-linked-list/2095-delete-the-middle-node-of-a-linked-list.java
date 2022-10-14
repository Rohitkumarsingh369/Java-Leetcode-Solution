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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fast=head,slow=head;
        if(head.next==null)
            return null;
        int count=0;
        while(fast!=null && fast.next!=null)
        {
            slow=(count==0)?head:slow.next; //To make slow point to (mid-1)th node instead of mid
            count++;
            fast=fast.next.next;
        }
        ListNode toDel=slow.next;
        slow.next=toDel.next;
        toDel.next=null;
            return head;
    }
}