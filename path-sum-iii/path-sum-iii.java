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
    public int pathSum(TreeNode root, int sum) {
        dfs(root,sum,0);
        
        if(root!=null){
            pathSum(root.left,sum);
            pathSum(root.right,sum);
        }
        return ans;
    }
    public void dfs(TreeNode node, int sum, int currSum) {
        
        if(node==null) {
            return;
        }
        
        currSum = currSum + node.val;
        if(currSum==sum) {
                ans++;
        }
        
        dfs(node.left, sum, currSum);
        dfs(node.right, sum, currSum);
    }
    
}