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
        
        int left=maxPath(root.left);
         int right=maxPath(root.right);
        
        int maxpath=Math.max(Math.max(left,right)+root.val,root.val);
        
        int max=Math.max(maxpath,root.val+left+right);
        if(max>globalpath)
            globalpath=max;
        return maxpath;//parent call
    }
}