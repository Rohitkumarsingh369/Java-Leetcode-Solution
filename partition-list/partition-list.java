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
    public ListNode partition(ListNode head, int x) {
         
        
        ListNode lessThan = new ListNode(-1);
        ListNode greaterThan = new ListNode(-2);
        // Dummmy Pointer to mark start of lessThan and greaterThan Node
        ListNode dummyPL = lessThan;
        ListNode dummyPG = greaterThan;
        ListNode current = head;
        
        // Adding next element to LessThan and GreaterThan
        while(current != null){
            if(current.val < x){
                lessThan.next = current;
                lessThan = current;
                current = current.next;
             }else{
                 greaterThan.next=current;
                 greaterThan=current;
                current= current.next;
                greaterThan.next = null;
             }
        }
        
        // connect lessThan with GreaterThan
        if(dummyPG.next!=null){
           if(lessThan != null){
                lessThan.next = dummyPG.next;
            }
        }
        
        if(dummyPL.next != null)
            return dummyPL.next;
        else
            return null;
    }        
    }
