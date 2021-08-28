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
    public ListNode swapPairs(ListNode head) {
       /* if(head==null)
            return null;
        ListNode temp=head;
       // ListNode swap=null;
        while(temp!=null && temp.next!=null){
            int k=temp.val;
            temp.val=temp.next.val;
            temp.next.val=k;
            temp=temp.next.next;
        }
        return head;*/
        if(head==null || head.next==null)
         return head;
         
        ListNode prev=head;
        ListNode curr=head.next;
        
        head=curr;
        
        while(true){
            ListNode next=curr.next;
             curr.next=prev;
            if(next==null  || next.next==null){
                prev.next=next;
                break;
            }
            prev.next=next.next;
            prev=next;
            curr=prev.next;
        }
        return head;
    }
}