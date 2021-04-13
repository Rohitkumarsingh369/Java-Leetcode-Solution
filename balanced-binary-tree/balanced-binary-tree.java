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
    public boolean isBalanced(TreeNode root) {
        if(root==null || (root.left==null&&root.right==null))
            return true;
        int result=Math.abs(height(root.left)-height(root.right));
        if(result<=1 && isBalanced(root.left) && isBalanced(root.right))
            return true;
        
        return false;
    }
    public int height(TreeNode root){
        if(root==null)
            return 0;
        return Math.max(height(root.left),height(root.right))+1;
    }
}