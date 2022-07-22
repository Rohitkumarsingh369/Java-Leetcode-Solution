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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode temp1 = l1;
        ListNode temp2 = l2;
        ListNode temp = new ListNode();
        ListNode head = temp;
        int carry = 0;
        String str = "";
        while(temp1!=null||temp2!=null||carry!=0)
        {
            int sum = (temp1!=null?temp1.val:0)+(temp2!=null?temp2.val:0)+carry;
            if(sum>9)
            {
                ListNode node = new ListNode(sum%10);
                temp.next = node;
                carry = 1; //if sum>9, then carry is always 1 because the numbers in both the linked list is between 0 and 9
            }else{
                ListNode node = new ListNode(sum);
                temp.next = node;
                carry = 0; //because sum<=9
            }
            temp=temp.next;
            if(temp1!=null)temp1 = temp1.next;
            if(temp2!=null)temp2 = temp2.next;
        }
        return head.next;
    }
}