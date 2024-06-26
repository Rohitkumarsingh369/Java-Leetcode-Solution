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
    public TreeNode balanceBST(TreeNode root) {
       List<Integer> sortedNodes = new ArrayList<>();
        inorderTraversal(root, sortedNodes);
        return sortedArrayToBST(sortedNodes, 0, sortedNodes.size() - 1);
    }

    // Method for inorder traversal to get sorted node values
    private void inorderTraversal(TreeNode root, List<Integer> sortedNodes) {
        if (root == null) return;
        inorderTraversal(root.left, sortedNodes);
        sortedNodes.add(root.val);
        inorderTraversal(root.right, sortedNodes);
    }

    // Method to convert sorted array to balanced BST
    private TreeNode sortedArrayToBST(List<Integer> sortedNodes, int start, int end) {
        if (start > end) return null;
        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(sortedNodes.get(mid));
        node.left = sortedArrayToBST(sortedNodes, start, mid - 1);
        node.right = sortedArrayToBST(sortedNodes, mid + 1, end);
        return node;
    }
}