/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null)
            return null;
        
        ListNode slow=head,fast=head;
        
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return startLoopPoint(slow,head);
            }
        }
        return null;
    }
    private ListNode startLoopPoint(ListNode node,ListNode head){
        ListNode temp=head;
        
        while(temp!=node){
            temp=temp.next;
            node=node.next;
        }
        return temp;
    }
}