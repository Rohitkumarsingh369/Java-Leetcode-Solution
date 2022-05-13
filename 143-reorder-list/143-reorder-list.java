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
    left = head;
    dfs(head);
}

ListNode left = null;
public void dfs(ListNode right){
    if(right == null)
        return;
    
    dfs(right.next);
    
    if(left.next != null){
        ListNode lNext = left.next;
        left.next = right;
        right.next = lNext;
        left = lNext;
    }
    if(left.next == right){
        left.next = null;
    }
    

}
}