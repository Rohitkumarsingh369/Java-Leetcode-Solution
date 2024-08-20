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
    
    private int currentCount = 0;
    private int maxCount = 0;
    private Integer previousValue = null;
    private List<Integer> modes = new ArrayList<>();

    public int[] findMode(TreeNode root) {
        // Traverse the BST
        inOrderTraversal(root);

        // Convert the list of modes to an array
        int result[]=new int[modes.size()];
        for(int i=0;i<modes.size();i++){
            result[i]=modes.get(i);
        }
        return result;
    }
    private void inOrderTraversal(TreeNode node) {
        if (node == null) return;

        // Traverse the left subtree
        inOrderTraversal(node.left);

        // Process the current node
        if (previousValue == null || node.val != previousValue) {
            currentCount = 1;
        } else {
            currentCount++;
        }
        previousValue = node.val;

        // Update modes list if current count matches max count
        if (currentCount > maxCount) {
            maxCount = currentCount;
            modes.clear();
            modes.add(node.val);
        } else if (currentCount == maxCount) {
            modes.add(node.val);
        }

        // Traverse the right subtree
        inOrderTraversal(node.right);
    }
}