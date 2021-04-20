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
    int level=0,leftval=0;
    public int findBottomLeftValue(TreeNode root) {
        helper(root,0);
        return leftval;
    }
    public void helper(TreeNode root,int count){
        if(root==null)
            return;
        
        if(level==count){
            leftval=root.val;
            level++;
        }
        
        helper(root.left,count+1);
        helper(root.right,count+1);
    }
}