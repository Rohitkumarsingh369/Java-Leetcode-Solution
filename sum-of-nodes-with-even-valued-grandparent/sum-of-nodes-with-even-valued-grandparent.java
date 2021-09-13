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
     int sum=0;
    public int sumEvenGrandparent(TreeNode root) {
       
        sumofevengrandparents(root,null,null);
        return sum;
    }
    public void sumofevengrandparents(TreeNode root,TreeNode p,TreeNode gp){
        if(root==null)
            return;
        
        
        if(gp!=null && gp.val%2==0)
            sum+=root.val;
        
        sumofevengrandparents(root.left,root,p);
        sumofevengrandparents(root.right,root,p);
    }
}