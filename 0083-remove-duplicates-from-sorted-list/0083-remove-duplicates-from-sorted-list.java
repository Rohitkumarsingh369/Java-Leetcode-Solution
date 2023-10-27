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
        
       /* if(head==null)
            return null;
        
        
        ListNode curr=head;
        
        
        while(curr!=null){
            ListNode temp=curr;
            
            while(temp!=null && temp.val==curr.val){
                temp=temp.next;
            }
            curr.next=temp;
            curr=curr.next;
        }
        
        return head;*/
        if(head == null || head.next == null) return head;
        
        ListNode list = head;
         while(list.next != null) 
         {
             if (list.val == list.next.val)
                 list.next = list.next.next;
             else 
                 list = list.next;
         }

         return head;
    }
}