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
    public int deepestLeavesSum(TreeNode root) {
        int max= maxdepth(root);
        return sum(root,max);
    }
    public int maxdepth(TreeNode root){
        if(root==null)
            return 0;
        return 1+Math.max(maxdepth(root.left),maxdepth(root.right));
    }
    public int sum(TreeNode root,int max){
        if(root==null)
            return 0;
        if(max==1)
            return root.val;
        
        return sum(root.left,max-1)+sum(root.right,max-1);
    }
}