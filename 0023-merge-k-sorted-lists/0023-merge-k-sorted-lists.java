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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode temp=new ListNode(-1);
        PriorityQueue<ListNode> queue = new PriorityQueue<>((o1,o2)->o1.val-o2.val);
        for(ListNode node:lists) {
            if(node!=null) {
                queue.add(node);                
            }
        }
        ListNode dummy = temp;
        while(!queue.isEmpty()) {
            temp.next=queue.poll();
            temp=temp.next;
            if(temp.next!=null) {
                queue.add(temp.next);
            }
        }
        
        return dummy.next;
    }
}