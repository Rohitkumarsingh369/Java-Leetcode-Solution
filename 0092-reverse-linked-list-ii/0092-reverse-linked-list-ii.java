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
        //creating dummy node 
        ListNode dummy=new ListNode(0);
        dummy.next=head;

        ListNode leftprev=dummy;
        ListNode currnode=head;

        for(int i=0;i<left-1;i++){
            leftprev=leftprev.next;
            currnode=currnode.next;
        }

        ListNode sublisthead=currnode;

        ListNode prevnode=null;
        
        for(int i=0;i<=right-left;i++){

            ListNode nextnode=currnode.next;
            currnode.next=prevnode;
            prevnode=currnode;
            currnode=nextnode;
        }

        leftprev.next=prevnode;
        sublisthead.next=currnode;

        return dummy.next;
    }
}