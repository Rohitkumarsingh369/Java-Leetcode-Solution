// { Driver Code Starts
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
    
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
    
	        while(t > 0){
	            String s = br.readLine();
    	    	Node root = buildTree(s);
        	    Level_Order_Traverse g = new Level_Order_Traverse();
                ArrayList<ArrayList<Integer>> result = g.levelOrder(root);
                for(ArrayList<Integer> values : result){
                    for(int value : values){
                        System.out.print(value + " ");
                    }
                    System.out.print("$ ");
                }
    			System.out.println();
                t--;
            
        }
    }
   
}// } Driver Code Ends


/*class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/


class Level_Order_Traverse
{
    //Function to return the level order traversal line by line of a tree.
    static ArrayList<ArrayList<Integer>> levelOrder(Node root) 
    {
       ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> level=new ArrayList<>();
        
        if(root==null)
        return result;
        
        Queue<Node> q=new LinkedList<Node>();
		
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node cur=q.poll();
			
			if(cur==null) {
				if(!q.isEmpty()) {
					q.add(null);
				
				}
				if(!level.isEmpty()){
                result.add(new ArrayList<>(level));
                    level.clear();
				}
			}
			else {
				if(cur.left!=null)
					q.add(cur.left);
				
				if(cur.right!=null)
					q.add(cur.right);
				
				level.add(cur.data);
			}
		}
		return result;
    }
}