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
    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        
        ListNode curr=dummy;
        int sum=0;
        HashMap<Integer,ListNode> sumMap=new HashMap<>();
        
        while(curr!=null){
            sum+=curr.val;
            if(sumMap.containsKey(sum)){
                ListNode prev=sumMap.get(sum).next;
                int sumTemp=sum+prev.val;
                while(prev!=curr){
                    sumMap.remove(sumTemp);
                    prev=prev.next;
                    sumTemp+=prev.val;
                }
                sumMap.get(sum).next=curr.next;
            }
            else{
                sumMap.put(sum,curr);
            }
            curr=curr.next;
        }
        return dummy.next;
    }
}