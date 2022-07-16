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
       //return isbst(root,null,null);
        if (root == null) return true;
       Stack<TreeNode> stack = new Stack<>();
       TreeNode pre = null;
       while (root != null || !stack.isEmpty()) {
          while (root != null) {
             stack.push(root);
             root = root.left;
          }
          root = stack.pop();
          if(pre != null && root.val <= pre.val) return false;
          pre = root;
          root = root.right;
       }
       return true;
    }
    
   /* public boolean isbst(TreeNode root,TreeNode leftnode,TreeNode rightnode){
        if(root==null)
            return true;
        
        if(leftnode!=null && root.val<=leftnode.val)
            return false;
        
        if(rightnode!=null && root.val>=rightnode.val)
            return false;
        
        return isbst(root.left,leftnode,root)&& isbst(root.right,root,rightnode);
    }*/
}