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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> items = new ArrayList<>();
        inorderTraversal(root, items);
        return items;
    }
    
    private void inorderTraversal(TreeNode root, List<Integer> items){        
        if(root == null) return;                      
        inorderTraversal(root.left, items);
        items.add(root.val);
        inorderTraversal(root.right, items);
    }
}