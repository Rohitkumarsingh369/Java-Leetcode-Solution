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
    // To keep track of the previous node value
    private TreeNode prev = null;
    // To store the minimum difference found
    private int minDiff = Integer.MAX_VALUE;
    
    public int getMinimumDifference(TreeNode root) {
        inOrderTraversal(root);
        return minDiff;
    }

    // In-order traversal to find the minimum difference
    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inOrderTraversal(node.left);

        // If prev is not null, calculate the difference and update minDiff
        if (prev != null) {
            minDiff = Math.min(minDiff, node.val - prev.val);
        }

        // Update prev to the current node before moving to the right subtree
        prev = node;

        // Traverse the right subtree
        inOrderTraversal(node.right);
    }
}