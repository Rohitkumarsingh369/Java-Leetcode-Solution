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
    StringBuilder sb;
    private void doEv(TreeNode root){
        if(root == null)return;
        if(root.left == null && root.right==null){
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append('(');
        doEv(root.left);
        sb.append(')');
        if(root.right!=null){
        sb.append('(');
        doEv(root.right);
        sb.append(')');
        }
        return;
    }
    public String tree2str(TreeNode t) {
        sb = new StringBuilder();
        doEv(t);
        return sb.toString();
    }
}