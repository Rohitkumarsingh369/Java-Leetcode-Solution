/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        
    ListNode temp1=headA,temp2=headB;
    
    if(temp1==null || temp2==null){
        return null;
    }
    
    while(temp1!=temp2){
        temp1=temp1==null?headB:temp1.next;
        temp2=temp2==null?headA:temp2.next;
    }
    return temp1;
}
}