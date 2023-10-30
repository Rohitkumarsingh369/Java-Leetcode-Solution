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
    int globalpath=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return globalpath;
    }
    public int maxPath(TreeNode root){
        if(root==null)
            return 0;
        
        int left=Math.max(0,maxPath(root.left));
         int right=Math.max(0,maxPath(root.right));
        
        globalpath=Math.max(globalpath,left+right+root.val);
        
        return Math.max(left,right)+root.val;
    }
}