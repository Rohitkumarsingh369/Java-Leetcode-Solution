/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        // Base case: if root is null or root is one of p or q
        if (root == null || root == p || root == q) {
            return root;
        }

        // Recursively find LCA in left and right subtrees
        TreeNode leftLCA = lowestCommonAncestor(root.left, p, q);
        TreeNode rightLCA = lowestCommonAncestor(root.right, p, q);

        // If both leftLCA and rightLCA are non-null, p and q are found in different subtrees
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // If only one of leftLCA or rightLCA is non-null, return that one
        return (leftLCA != null) ? leftLCA : rightLCA;
    }
}