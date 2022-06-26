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
    int ans=0;
    public int distributeCoins(TreeNode root) {
        distributeCandyUtil(root);
        return ans;
    }
    
    public int distributeCandyUtil(TreeNode root)
    {
        // Base Case
        if (root == null)
            return 0;
 
        // Traverse left subtree
        int l = distributeCandyUtil(root.left);
 
        // Traverse right subtree
        int r = distributeCandyUtil(root.right);
 
        // Update number of moves
        ans += Math.abs(l) + Math.abs(r);
 
        // Return number of moves to balance
        // current node
        return root.val + l + r - 1;
    }
}