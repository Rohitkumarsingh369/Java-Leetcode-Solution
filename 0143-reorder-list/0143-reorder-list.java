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
    public void reorderList(ListNode head) {
        if(head == null)return;
        ListNode slow = head;
        ListNode fast = head;
        
        //1. find the middle of list
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode tmp = slow.next;//2nd half start from next node of the middle one
        slow.next = null;
        
        //2. reverse last half of list
        ListNode newHead = reverseList(tmp);
        
        //3. connect 1st half to 2nd half
        ListNode cur = head;
        while(cur != null && newHead != null){
            ListNode tmp1 = cur.next;
            ListNode tmp2 = newHead.next;
            cur.next = newHead;
            newHead.next = tmp1;
            cur = tmp1;
            newHead = tmp2;
        }
    }
    
    public ListNode reverseList(ListNode head) {
       /* if(head==null||head.next==null){ return head;}
        ListNode nextN = head.next;
        head.next = null;
        while(nextN != null){
            ListNode tmp = nextN.next;
            nextN.next = head;
            head = nextN;
            nextN = tmp;
        }
        return head;*/
        
        ListNode prev=null,curr=head;
        
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        return head;
    }
}