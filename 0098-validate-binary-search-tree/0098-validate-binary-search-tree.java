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
        return validate(root, null, null);
    }

    // Helper function to validate the BST by checking the min and max constraints
    private boolean validate(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;

        // Check the current node's value against the min and max constraints
        if (min != null && node.val <= min) return false;
        if (max != null && node.val >= max) return false;

        // Recursively validate the left and right subtrees with updated constraints
        return validate(node.left, min, node.val) && validate(node.right, node.val, max);
    }
}