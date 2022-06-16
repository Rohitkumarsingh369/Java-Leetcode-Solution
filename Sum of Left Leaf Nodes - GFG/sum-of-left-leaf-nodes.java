// { Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.leftLeavesSum(root));
            
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution{


    public int leftLeavesSum(Node root) 
    { 
       /* Stack<Node> stack=new Stack<>();
        
        stack.push(root);
        
        int sum=0;

        while(!stack.isEmpty()){
            Node current=stack.pop();
            
            if(current.left!=null){
                stack.push(current.left);
                
                if(current.left.left==null && current.left.right==null)
                    sum+=current.left.data;
            }
            if(current.right!=null){
                stack.push(current.right);
            }
        }
        
        return sum;*/
        int result=0;
        
        if(root!=null){
            if(isleaf(root.left)){
                result+=root.left.data;
            }
            else{
                result+=leftLeavesSum(root.left);
            }
            
            result+=leftLeavesSum(root.right);
        }
        
        return result;
        
    } 
    
    public boolean isleaf(Node root){
        if(root==null)
            return false;
            
        if(root.left==null && root.right==null)
            return true;
        
        return false;
    }
}
