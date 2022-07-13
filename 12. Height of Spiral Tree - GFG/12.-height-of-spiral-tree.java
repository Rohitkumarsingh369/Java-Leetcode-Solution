// { Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

class GfG {
    
    static Node buildTree(String str){
        
        if(str.length()==0 || str.charAt(0)=='N'){
            return null;
        }
        
        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue
        
        Queue<Node> queue = new LinkedList<>(); 
        
        queue.add(root);
        // Starting from the second element
        
        int i = 1;
        while(queue.size()>0 && i < ip.length) {
            
            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();
                
            // Get the current node's value from the string
            String currVal = ip[i];
                
            // If the left child is not null
            if(!currVal.equals("N")) {
                    
                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }
                
            // For the right child
            i++;
            if(i >= ip.length)
                break;
                
            currVal = ip[i];
                
            // If the right child is not null
            if(!currVal.equals("N")) {
                    
                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));
                    
                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }
        
        return root;
    }
    static void printInorder(Node root)
    {
        if(root == null)
            return;
            
        printInorder(root.left);
        System.out.print(root.data+" ");
        
        printInorder(root.right);
    }
    
    
    public static void makeSpiral(Node root)
    {
	    ArrayList<Node> l = new ArrayList<>();
	    makeLeaves(root, l);
	    
	    //po(l);
	    
	    if(l.size() <= 1)
	        return;
	    
	    l.get(0).left = l.get(l.size()-1);
	    l.get(0).right = l.get(1);
	    l.get(l.size()-1).left = l.get(l.size()-2);
	    l.get(l.size()-1).right = l.get(0);
	    
	    for(int i=1; i<l.size()-1; i++){
            l.get(i).right = l.get(i+1);
            l.get(i).left = l.get(i-1);
	    }
	}
	
	public static void makeLeaves(Node node, ArrayList<Node> leaves)
	{
        if(node == null)
            return;
        
        if(node.left == null && node.right == null){
            leaves.add(node);
            return;
        }
        
        makeLeaves(node.left, leaves);
        makeLeaves(node.right, leaves);
    }
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Tree g = new Tree();
			    makeSpiral(root);
			    int ans = g.findTreeHeight(root);
			    System.out.println(ans);
                t--;
            
        }
    }
  
}

// } Driver Code Ends


class Tree
{
    // Return the height of the given special binary tree
    public static int findTreeHeight(Node root)
        {
            // code here.
             if(root==null) return 0;
           
           if(root.left!=null && root.left.right==root){
               return 1;
           }
           int lh = findTreeHeight(root.left);
           int rh = findTreeHeight(root.right);
           
           return 1+Math.max(lh,rh);
        }
}