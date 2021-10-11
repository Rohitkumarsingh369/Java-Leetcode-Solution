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
    private int max;
    
    public int diameterOfBinaryTree(TreeNode root) {
        deepestPath(root);
        return max;
    }
    
    private int deepestPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = deepestPath(node.left);
        int right = deepestPath(node.right);
        max = Math.max(max, left + right);
        return Math.max(left, right) + 1;
    }
}