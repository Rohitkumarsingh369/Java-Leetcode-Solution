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
    public long res = Long.MAX_VALUE;
    public int findSecondMinimumValue(TreeNode root) {
        int min=root.val;
        if(root.left==null && root.right==null)
            return -1;
        
        pre(root,min);
        if(res!=Long.MAX_VALUE)
            return (int)res;
        
        return -1;
    }
    public void pre(TreeNode root,int min){
        if(root==null)
            return ;
        
        if(root.val!=min && root.val<res)
            res=root.val;
        
        pre(root.left,min);
        pre(root.right,min);
    }
}