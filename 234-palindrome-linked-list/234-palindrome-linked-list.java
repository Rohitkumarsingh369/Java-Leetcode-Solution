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
    public boolean isPalindrome(ListNode head) {
        if(head==null)
            return false;
        
        Stack<ListNode> stk=new Stack<>();
        
        ListNode temp=head;
        while(temp!=null){
            stk.push(temp);
            temp=temp.next;
        }
        temp=head;
        while(temp!=null){
            ListNode node=stk.peek();
            stk.pop();
            
            if(temp.val!=node.val)
                return false;
            temp=temp.next;
        }
        return true;
    }
}