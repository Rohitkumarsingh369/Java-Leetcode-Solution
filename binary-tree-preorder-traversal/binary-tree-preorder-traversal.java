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
     List<Integer> result=new ArrayList<>();
    public List<Integer> preorderTraversal(TreeNode root) {
       
        if(root==null)
            return result;
        
        
        return preorder(root,result);
    }
     public  List<Integer> preorder(TreeNode root,List<Integer> result) {
         if(root!=null){
             result.add(root.val);
             preorder(root.left,result);
             preorder(root.right,result);
         }
         return result;
     }
}