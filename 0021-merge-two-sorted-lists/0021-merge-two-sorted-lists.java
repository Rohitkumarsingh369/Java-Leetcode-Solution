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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummyNode=new ListNode(0);
        
        ListNode tail=dummyNode;
        
        while(true){
            if(list1==null){
                tail.next=list2;
                break;
            }
            if(list2==null){
                tail.next=list1;
                break;
            }
            
            if(list1.val<=list2.val){
                tail.next=list1;
                list1=list1.next;
            }
            else{
                tail.next=list2;
                list2=list2.next;
            }
            
            tail=tail.next;
        }
       return dummyNode.next; 
        
      /*  if(list1==null)
            return list2;
        
        if(list2==null)
            return list1;
        
        if(list1.val>list2.val){
            ListNode swap=list1;
            list1=list2;
            list2=swap;
        }
        
        ListNode res=list1;
        while(list1!=null && list2!=null){
            ListNode temp=null;
            
            while(list1!=null && list1.val<=list2.val){
                temp=list1;
                list1=list1.next;
            }
            
            temp.next=list2;
            
            ListNode swap=list1;
            list1=list2;
            list2=swap;
        }
        return res;*/
    }
}