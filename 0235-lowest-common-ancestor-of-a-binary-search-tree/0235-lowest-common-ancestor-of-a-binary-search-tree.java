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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
         if(root==null)
            return null;
        
        //if TreeNode p & q are less then root node
        if(root.val>p.val && root.val>q.val)
            return lowestCommonAncestor(root.left,p,q);
        
        //if TreeNode p & q are greater then root node
        if(root.val<p.val && root.val<q.val)
            return lowestCommonAncestor(root.right,p,q);
        
        
        return root;
        
    }
}