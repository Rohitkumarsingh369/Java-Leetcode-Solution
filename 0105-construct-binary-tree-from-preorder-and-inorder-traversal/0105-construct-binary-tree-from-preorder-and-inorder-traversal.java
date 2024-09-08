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
    // Function to build the tree
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        // Create a map to store value to index mappings for inorder traversal
        Map<Integer, Integer> inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        
        return buildTreeHelper(preorder, 0, preorder.length - 1, 
                               inorder, 0, inorder.length - 1, 
                               inorderIndexMap);
    }

    // Helper function to construct the tree
    private static TreeNode buildTreeHelper(int[] preorder, int preorderStart, int preorderEnd,
                                            int[] inorder, int inorderStart, int inorderEnd,
                                            Map<Integer, Integer> inorderIndexMap) {
        if (preorderStart > preorderEnd || inorderStart > inorderEnd) {
            return null;
        }

        // The first element in preorder is the root
        int rootValue = preorder[preorderStart];
        TreeNode root = new TreeNode(rootValue);

        // Find the root index in inorder traversal
        int rootIndexInOrder = inorderIndexMap.get(rootValue);

        // Number of nodes in the left subtree
        int leftTreeSize = rootIndexInOrder - inorderStart;

        // Recursively build the left and right subtrees
        root.left = buildTreeHelper(preorder, preorderStart + 1, preorderStart + leftTreeSize,
                                    inorder, inorderStart, rootIndexInOrder - 1,
                                    inorderIndexMap);
        root.right = buildTreeHelper(preorder, preorderStart + leftTreeSize + 1, preorderEnd,
                                     inorder, rootIndexInOrder + 1, inorderEnd,
                                     inorderIndexMap);

        return root;
    }
}