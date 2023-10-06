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
    public int maxDepth(TreeNode root) {
      /*  if(root==null)
            return 0;
        
        else{
            int Ldepth=maxDepth(root.left);
            int Rdepth=maxDepth(root.right);
            
            if(Ldepth>Rdepth)
                return (Ldepth+1);
            else
                return (Rdepth+1);
        }*/
        
        /*if(root==null)
            return 0;
        
        else{
            int leftdepth=maxDepth(root.left);
            int rightdepth=maxDepth(root.right);
            
            if(leftdepth>rightdepth)
                return leftdepth+1;
            else 
                return rightdepth+1;
        }*/
        
        if(root==null)
            return 0;
        else{
            int leftDepth=maxDepth(root.left);
            int rightDepth=maxDepth(root.right);
            
            return 1+ Math.max(leftDepth,rightDepth);
        }
        
    }
}