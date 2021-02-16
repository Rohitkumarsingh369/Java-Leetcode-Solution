/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode n1, TreeNode n2) {
        
        if(root==null)
	    return  null;
	    
	    if(root==n1 || root==n2)
	    return root;
	    
	    TreeNode left_lca=lowestCommonAncestor(root.left,n1,n2);
	    TreeNode right_lca=lowestCommonAncestor(root.right,n1,n2);
	    
	    if(left_lca!=null && right_lca!=null)
	        return root;
	        
	   return (left_lca!=null)?(left_lca):(right_lca);
    }
}