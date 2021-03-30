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
    public List<Integer> postorderTraversal(TreeNode root) {
       
        if(root==null)
            return result;
        
        
        return postorder(root,result);
    }
     public  List<Integer> postorder(TreeNode root,List<Integer> result) {
         if(root!=null){
             postorder(root.left,result);
             postorder(root.right,result);
             result.add(root.val);
         }
         return result;
     }
}