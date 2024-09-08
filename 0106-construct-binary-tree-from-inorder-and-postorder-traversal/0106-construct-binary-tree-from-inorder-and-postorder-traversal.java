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
    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        // Create a map to store value to index mappings for inorder traversal
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(inorder, 0, inorder.length - 1, 
                               postorder, 0, postorder.length - 1, 
                               inorderIndexMap);
    }

    // Helper function to construct the tree
    private static TreeNode buildTreeHelper(int[] inorder, int inorderStart, int inorderEnd,
                                            int[] postorder, int postorderStart, int postorderEnd,
                                            Map<Integer, Integer> inorderIndexMap) {
        if (inorderStart > inorderEnd || postorderStart > postorderEnd) {
            return null;
        }

        // The last element in postorder is the root
        int rootValue = postorder[postorderEnd];
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in inorder traversal
        int rootIndexInOrder = inorderIndexMap.get(rootValue);

        // Number of nodes in the right subtree
        int rightTreeSize = inorderEnd - rootIndexInOrder;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(inorder, inorderStart, rootIndexInOrder - 1,
                                    postorder, postorderStart, postorderEnd - rightTreeSize - 1,
                                    inorderIndexMap);
        root.right = buildTreeHelper(inorder, rootIndexInOrder + 1, inorderEnd,
                                     postorder, postorderEnd - rightTreeSize, postorderEnd - 1,
                                     inorderIndexMap);

        return root;
    }

}