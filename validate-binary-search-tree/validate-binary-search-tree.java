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
    public boolean isValidBST(TreeNode root) {
        return validbst(root,null,null);
    }
    public boolean validbst(TreeNode root,TreeNode leftnode,TreeNode rightnode){
        if(root==null)
            return true;
        
        if(leftnode!=null && root.val<=leftnode.val)
            return false;
        
        if(rightnode!=null && root.val>=rightnode.val)
            return false;
        
        return validbst(root.left,leftnode,root)&&validbst(root.right,root,rightnode);
    }
}