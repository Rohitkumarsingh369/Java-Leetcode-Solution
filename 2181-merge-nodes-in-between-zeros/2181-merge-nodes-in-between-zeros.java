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
    public ListNode mergeNodes(ListNode head) {
        
        if(head.val==0){
            head=head.next;
        }
        
        // To store modified list
        ListNode result=head;
        
        // Traverse linked list and keep
        // adding nodes between 0s.
        ListNode temp=head;
        int sum=0;
        
        while(temp!=null){
            if(temp.val!=0){
                sum+=temp.val;
                temp=temp.next;
            }
            
            else{
                result.val=sum;
                result.next=temp.next;
                temp=result.next;
                result=result.next;
                sum=0;
            }
        }
        
        return head;
    }
}