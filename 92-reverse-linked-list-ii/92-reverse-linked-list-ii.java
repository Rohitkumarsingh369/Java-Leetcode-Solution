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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        int count=1;
        ListNode curr=head;
        ListNode revprev=null;
        while(count<m)
        {
            revprev=curr;
            curr=curr.next;
            count++;
        }
        ListNode revstart=curr;
        while(count<n){
            curr=curr.next;
            count++;
        }
        ListNode revend=curr;
        ListNode revnext=curr.next;
        curr.next=null;
        ListNode revpart=reverse(revstart);
        if(revprev!=null){
            revprev.next.next=revnext;
            revprev.next=revpart;
        }
        else{
            if(revnext!=null){
                head.next=revnext;
            }
            head=revpart;
        }
        return head;
    }
    public ListNode reverse(ListNode head){
       ListNode prev=null;
        ListNode next=null;
        ListNode curr=head;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}