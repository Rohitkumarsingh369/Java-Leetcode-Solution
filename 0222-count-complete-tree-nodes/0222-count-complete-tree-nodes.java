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
/*class Solution {
    public int countNodes(TreeNode root) {
        
    }
}*/
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = leftHeight(root);
        int rightHeight = rightHeight(root);

        if (leftHeight == rightHeight) {
            // The tree is a full binary tree, and the number of nodes can be calculated directly.
            return (1 << leftHeight) - 1;
        } else {
            // The tree is not full, recurse on left and right subtrees.
            return 1 + countNodes(root.left) + countNodes(root.right);
        }
    }

    private int leftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int rightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

}