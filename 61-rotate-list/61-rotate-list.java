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
    public ListNode rotateRight(ListNode head, int k) {
        
        int length=0;
        ListNode temp = head;
        ListNode root = head;

        while(temp!=null){ 
            length++;
            temp=temp.next;
        }


        if(k!=0 && length!=0 && k%length!=0 ) {
            int rotation=(length)-(k>=length?k%length:k);

            ListNode prev=null;
            while(rotation>0) {
                prev=head;
                head=head.next;
                rotation--;
            }
            if(prev!=null) {
                prev.next=null;
                ListNode res=head;
                while(res!=null) {
                    if(res.next==null) {
                        res.next=root;
                        break;
                    }
                    res=res.next;
                }
            } 
        }
        return head; 
    }
}