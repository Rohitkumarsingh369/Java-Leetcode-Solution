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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        ListNode prevLast=null;

        while(temp!=null){
            ListNode kthNode=getKthNode(temp,k);
            
            if(kthNode==null){
                    if(prevLast!=null){
                        prevLast.next=temp;
                    }
                    break;
            }
            ListNode nextNode=kthNode.next;
            kthNode.next=null;

            reverseList(temp);
            if(temp==head){
                head=kthNode;
            }
            else{
                prevLast.next=kthNode;
            }
            prevLast=temp;
            temp=nextNode;
        }
        return head;
    }
    public  ListNode getKthNode(ListNode temp,int k){
        k--;
        while(temp!=null && k>0){
            k--;
            temp=temp.next;
        }
        return temp;
    }
    public  ListNode reverseList(ListNode head){
            ListNode prev=null;
            ListNode curr=head;
            while(curr!=null){
                ListNode next=curr.next;
                curr.next=prev;
                prev=curr;
                curr=next;
            }
            return prev;
    }
}