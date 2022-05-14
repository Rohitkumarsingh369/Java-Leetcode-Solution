// { Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}
// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        Node newHead = head;
        Node latestVowel;
        Node curr = head;

        if (head == null) {
            return null;
        }


        if (isVowel(head.data)) {

            latestVowel = head;
        } else {

            while (curr.next != null && !isVowel(curr.next.data)) {
                curr = curr.next;
            }

            if (curr.next == null) {
                return head;
            }

            latestVowel = newHead = curr.next;
            curr.next = curr.next.next;
            latestVowel.next = head;
        }


        while ( curr != null && curr.next != null ) {
            if (isVowel(curr.next.data)) {

                if (curr == latestVowel) {

                    latestVowel = curr = curr.next;
                } else {

                    Node temp = latestVowel.next;   
                    latestVowel.next = curr.next;   
                    latestVowel = latestVowel.next; 
                    curr.next = curr.next.next;    
                    latestVowel.next = temp;        
                }
            } else {

                curr = curr.next;
            }
        }
        return newHead;
    }
     public static boolean isVowel(char ch)
    {
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
        {
            return true;
        }
        else
            return false;

    }
}