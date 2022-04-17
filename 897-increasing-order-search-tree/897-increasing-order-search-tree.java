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
    
    private TreeNode head = null, parent = null;
    public TreeNode increasingBST(TreeNode root) {
        solve(root);
        return head;
    }
    
    private void solve(TreeNode root){
        if(root == null) return;
        solve(root.left);
        if(head == null) head = root;
        if(parent == null) parent = root;
        else {
            parent.right = root;
            parent = root;
            root.left = null;
        }
        solve(root.right); 
    }
}