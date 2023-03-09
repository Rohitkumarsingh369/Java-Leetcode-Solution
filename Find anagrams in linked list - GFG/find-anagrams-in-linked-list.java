//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;

    Node(char x) {
        data = x;
        next = null;
    }

    public static Node inputList(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List

        String[] s = br.readLine().trim().split(" ");
        Node head = new Node((s[0].charAt(0))), tail = head;
        for (int i = 1; i < s.length; i++)
            tail = tail.next = new Node((s[i].charAt(0)));

        return head;
    }

    public static void printList(Node node, PrintWriter out) {
        while (node != null) {
            out.print(node.data + " ");
            node = node.next;
        }
        out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            Node head = Node.inputList(br);

            String S = br.readLine().trim();

            Solution obj = new Solution();
            ArrayList<Node> res = obj.findAnagrams(head, S);

            for (Node node : res) {
                Node temp = node;
                Node.printList(temp, out);
            }
            if (res.size() == 0) {
                out.println("-1");
            }
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*

Definition for singly Link List Node
class Node
{
    char data;
    Node next;

    Node(char x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    public static ArrayList<Node> findAnagrams(Node head, String S) {
        // code here
          // Initialize an empty list to store the nodes containing the anagrams of S
    ArrayList<Node> ans = new ArrayList<>();
    // Initialize a counter j to keep track of the length of the current window
    int j = 0;
    // Initialize the current and previous nodes to the head of the linked list
    Node prev = head, curr = head;
    // Loop through the linked list until the current node is null
    while (curr != null) {
        // Initialize an integer array to keep track of the frequency of characters in S
        int arr[] = new int[26];
        // Count the frequency of each character in S
        for (int i = 0; i < S.length(); i++)
            arr[S.charAt(i) - 'a']++;
        // Loop through the linked list until the end of the window or until all characters in S have been found
        while (j < S.length() && curr != null) {
            // Decrement the frequency of the character in the window and move the current node pointer if the frequency is positive
            if (--arr[curr.data - 'a'] >= 0) {
                j++;
                curr = curr.next;
            } else {
                // Break out of the loop if the frequency is negative, indicating a character outside of S has been found
                break;
            }
        }
        // Check if all characters in S have been found and the frequency array is all zeroes, indicating an anagram has been found
        if (j == S.length() && checkAllZeroes(arr)) {
            // Create a new linked list to store the characters in the current window
            Node temp = new Node('x');
            Node ptr = temp;
            // Append the characters in the current window to the new linked list
            while (j > 0) {
                temp.next = new Node(prev.data);
                prev = prev.next;
                temp = temp.next;
                j--;
            }
            // Add the head of the new linked list to the list of anagrams
            ans.add(ptr.next);
        } else {
            // If an anagram has not been found, increment the previous node and reset the window counter
            prev = prev.next;
            j = 0;
        }
        // Set the current node to the previous node for the next iteration of the outer loop
        curr = prev;
    }
    // Return the list of nodes containing the anagrams of S
    return ans;
}

// Helper function to check if all elements in an integer array are zero
static boolean checkAllZeroes(int arr[]) {
    for (int i : arr)
        if (i != 0)
            return false;
    return true;
}
}