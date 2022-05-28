// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}



// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node zerodummy=new Node(0);
        Node onedummy=new Node(0);
        Node twodummy=new Node(0);
        
        Node zero=zerodummy,one=onedummy,two=twodummy;
        Node temp=head;
        
        while(temp!=null){
            if(temp.data==0){
                zero.next=temp;
                zero=zero.next;
                temp=temp.next;
            }
            else if(temp.data==1){
                one.next=temp;
                one=one.next;
                temp=temp.next;
            }
            else{
                two.next=temp;
                two=two.next;
                temp=temp.next;
            }
        }
        
        
        zero.next=(onedummy.next!=null)?onedummy.next:twodummy.next;
        one.next=twodummy.next;
        two.next=null;
        head=zerodummy.next;
        return head;
    }
}


