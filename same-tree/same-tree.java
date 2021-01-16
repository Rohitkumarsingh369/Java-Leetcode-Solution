/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode a, TreeNode b) {
        if (a == null && b == null) 
        return true; 
 
    // 2. both non-empty . compare them 
    if (a != null && b != null) 
    { 
        return
        (   (a.val==b.val) &&
            isSameTree(a.left, b.left) && 
            isSameTree(a.right, b.right) 
        ); 
    } 
     
    // 3. one empty, one not . false 
    return false; 
    }
}
