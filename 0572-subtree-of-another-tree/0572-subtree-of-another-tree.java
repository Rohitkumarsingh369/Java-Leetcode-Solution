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
public class Solution {
   public boolean isSubtree(TreeNode tree, TreeNode subtree) {
        if (tree == null) return false; // An empty tree cannot contain a non-empty subtree
        if (isSame(tree, subtree)) return true; // Check if the current node matches the subtree
        return isSubtree(tree.left, subtree) || isSubtree(tree.right, subtree); // Recursively check left and right subtrees
    }

    // Method to check if two trees are identical
    private boolean isSame(TreeNode tree, TreeNode subtree) {
        if (tree == null && subtree == null) return true; // Both are null, they are identical
        if (tree == null || subtree == null) return false; // One is null, the other is not
        if (tree.val != subtree.val) return false; // Values do not match
        
        // Recursively check left and right children
        return isSame(tree.left, subtree.left) && isSame(tree.right, subtree.right);
    }
}