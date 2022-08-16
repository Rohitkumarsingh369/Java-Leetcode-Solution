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
    public ListNode removeNthFromEnd(ListNode head, int n) {
	 
        if(n<=0)
            return head;
        
        ListNode temp=head;
        for(int i=1;i<n && temp!=null;i++){
            temp=temp.next;
        }
        
       
        
        ListNode curr=head;
        ListNode prev=null;
        
        while(temp.next!=null){
            prev=curr;
            curr=curr.next;
            temp=temp.next;
        }
        
        if(curr==head)
            return head.next;
        
        else{
            prev.next=curr.next;
            return head;
        }
    }
}

