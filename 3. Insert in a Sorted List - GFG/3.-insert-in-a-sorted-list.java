// { Driver Code Starts
import java.util.*;
import java.io.*;

class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
    
}
class GFG{
	static void printList(Node node) 
	{ 
		while (node != null) 
		{ 
			System.out.print(node.data + " "); 
			node = node.next; 
		} 
		System.out.println(); 
	}
	
    public static void main(String args[]) throws IOException { 
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int n = sc.nextInt();
            
            Node head = new Node(sc.nextInt());
            Node tail = head;
            
            for(int i=0; i<n-1; i++)
            {
                tail.next = new Node(sc.nextInt());
                tail = tail.next;
            }
            
            int k = sc.nextInt();
            
            Solution g = new Solution();
            head = g.sortedInsert(head,k);
            
            printList(head); 
            t--;
        }
    } 
} 
// } Driver Code Ends


/*class Node
    {
        int data;
        Node next;
        Node(int d) {data = d; next = null; }
    }*/

// sortedInsert method should return the head of the modified linked list.
class Solution {
    Node sortedInsert(Node head, int key) {
        // Add your code here.
        
        //make the node with the value given`
        /*Node new_node=new Node(key);
        
        Node current;
 
        /* Special case for head node */
       /* if (head == null || head.data>= new_node.data) {
            new_node.next = head;
            head = new_node;
        }
        else {
 
            /* Locate the node before point of insertion. */
           /* current = head;
 
            while (current.next != null&& current.next.data < new_node.data)
                current = current.next;
 
            new_node.next = current.next;
            current.next = new_node;
        }
        return head;*/
        
        Node current;
        Node newnode=new Node(key);
        
        if(head==null || head.data>=newnode.data){
            newnode.next=head;
            head=newnode;
        }
        else{
            current=head;
            while(current.next!=null && current.next.data<newnode.data){
                current=current.next;
            }
            
            newnode.next=current.next;
            current.next=newnode;
        }
        
        return head;
    }
}