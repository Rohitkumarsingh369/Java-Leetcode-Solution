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
    ArrayList<Integer> res = new ArrayList<>();
    int count = 0;
    int maxCount = Integer.MIN_VALUE;
    TreeNode prev = null;
    public int[] findMode(TreeNode root) {
        dfs(root);
        int size = res.size();
        int[] ans = new int[size];
        for(int i = 0; i < size; i++){
            ans[i] = res.get(i);
        }
        return ans;
    }
    void dfs(TreeNode root){
        if(root == null) return;
        dfs(root.left);
        if(prev != null && root.val == prev.val){
            count++;
        }else{
            count = 1;
        }
        if(count == maxCount) res.add(root.val);
        if(count > maxCount){
            maxCount = count;
            res.clear();
            res.add(root.val);
        }
        prev = root;
        dfs(root.right);
    }
}