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
        ListNode prev=null;
        ListNode curr=head;
        
        while(curr!=null){
            ListNode temp=curr;
            while(temp!=null && temp.val==curr.val){
                temp=temp.next;
            }
            curr.next=temp;
            curr=curr.next;
        }
        
        return head;
    }
}