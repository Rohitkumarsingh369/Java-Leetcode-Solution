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
    private TreeNode parentX, parentY;
    private int depthX, depthY;
    
    private void dfs(TreeNode node, int x, int y, int depth, TreeNode parent) {
        if (node == null) return;
        
        if (node.val == x) {
            parentX = parent;
            depthX = depth;
        } else if (node.val == y) {
            parentY = parent;
            depthY = depth;
        }
        
        dfs(node.left, x, y, depth + 1, node);
        dfs(node.right, x, y, depth + 1, node);
    }
    
    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, x, y, 0, null);
        return (depthX == depthY) && (parentX != parentY);
    }
}