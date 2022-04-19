/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    static TreeNode prev,first,last,mid;
    public void recoverTree(TreeNode root) {
        prev=first=last=mid=null;
		swapcheck(root);
		
		// Fix (or correct) the tree 
        if( first != null && last != null ) 
        { 
            int temp = first.val; 
            first.val = last.val; 
            last.val = temp;  
        } 
        // Adjacent nodes swapped 
        else if( first != null && mid != null )  
        { 
            int temp = first.val; 
            first.val = mid.val; 
            mid.val = temp; 
        } 
    }
    static void swapcheck(TreeNode root) {
		if(root!=null) {
			swapcheck(root.left);
			
			if(prev!=null && root.val<prev.val) {
				if(first==null) {
					first=prev;
					mid=root;
				}
				else
					last=root;
			}
			prev=root;
			
			swapcheck(root.right);
		}
	}
}