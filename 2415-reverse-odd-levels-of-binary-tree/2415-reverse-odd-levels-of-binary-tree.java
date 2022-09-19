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
    public TreeNode reverseOddLevels(TreeNode root) {
        reverseOddLevels(root.left, root.right, 1);
        return root;
    }
    
    private void reverseOddLevels(TreeNode left, TreeNode right, int level) {
        if (left == null) {
            return;
        }
        
        if ((level & 1) == 1) {
            int val = left.val;
            left.val = right.val;
            right.val = val;
        }
        
        reverseOddLevels(left.left, right.right, level + 1);
        reverseOddLevels(left.right, right.left, level + 1);
    }
}