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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        TreeNode node = root;
        while (true) {
            if (val > node.val) { // Continue searching in the right subtree
                if (node.right != null) { // the position is occupied, continue to search
                    node = node.right;
                } else { // position is empty, insert position found, put val here
                    node.right = new TreeNode(val);
                    break;
                }
            } else { // Continue searching in the left subtree
                if (node.left != null) { // the position is occupied, continue to search
                    node = node.left;
                    } else { // position is empty, insert position found, put val here
                    node.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}