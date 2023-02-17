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
    List<Integer> al = new ArrayList();
    public int minDiffInBST(TreeNode root) {
        inOrder(root);
        int min = Integer.MAX_VALUE;
        for(int i=0;i<al.size()-1;i++){
            min = Math.min(min,al.get(i+1)-al.get(i));
        }
        return min;
    }
    public void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        al.add(root.val);
        inOrder(root.right);
    }
}