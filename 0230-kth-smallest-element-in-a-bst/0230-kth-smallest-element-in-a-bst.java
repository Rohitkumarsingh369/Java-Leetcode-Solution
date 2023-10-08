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
     int count=0;
    public int kthSmallest(TreeNode root, int k) {
        TreeNode result=kthsmallest(root,k);
        
        if(result!=null)
            return result.val;
        
        return -1;
    }
    
     public TreeNode kthsmallest(TreeNode root, int k)
    {
        // base case
        if (root == null)
            return null;
      
        // search in left subtree
        TreeNode left = kthsmallest(root.left, k);
      
        if(left!=null)
            return left;
      
        // if current element is k'th smallest, return it
        count++;
        if (count == k)
            return root;
      
        // else search in right subtree
        return kthsmallest(root.right, k);
    }
    
   
}