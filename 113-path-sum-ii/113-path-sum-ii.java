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
   public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        // List for storing the results
        List<List<Integer>> result = new ArrayList<>();
        helperPathSum(root, targetSum, result, new ArrayList<Integer>());
        return result;
    }
    
    private void helperPathSum(TreeNode root, int targetSum, List<List<Integer>> result, List<Integer> temp) {
        
        // Base Case
        if (root == null)
            return;
        
        // Leaf node found
        if (root.left == null && root.right == null) {
            
            // If remaining sum is 0 we found a path
            if(targetSum - root.val == 0) {
                // Add the current val to temporary list and then store the temporary list in main result
                temp.add(root.val);
                result.add(new ArrayList<Integer>(temp));
                // remove the last added node from temporary list
                temp.remove(temp.size() - 1);
            }
            return;
        }
        
        // add the current node val to temporary list and recursively make calls on left and right sub tree reducing the target value
        temp.add(root.val);
        helperPathSum(root.left, targetSum - root.val, result, temp);
        helperPathSum(root.right, targetSum - root.val, result, temp);
        temp.remove(temp.size() - 1);
        
    }
}