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
    int pre[];
    int post[];
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        this.pre = pre;
        this.post = post;
        return helper(0, pre.length-1, 0, post.length-1);
    }
    
    public TreeNode helper(int pre_start, int pre_end, int post_start, int post_end){
        if (post_start > post_end){
            return null;
        }
        
        int cur = pre[pre_start];
        TreeNode root = new TreeNode(cur);
        if (pre_start == pre_end){
            return root;
        }
        int left = pre[pre_start+1];
        int index = 0;
        for(int i = post_start; i<=post_end; i++){
            if (post[i]==left){
                index = i;
            }
        }
        root.left = helper(pre_start+1, pre_start+index-post_start+1, post_start, index);
        root.right = helper(pre_start+index-post_start+2, pre_end, index+1, post_end-1);
        return root;
    }
}