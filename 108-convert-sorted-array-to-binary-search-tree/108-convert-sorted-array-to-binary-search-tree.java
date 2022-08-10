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
    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=ArrayToBST(0,nums.length-1,nums);
        return root;
    }
    public TreeNode ArrayToBST(int start,int end,int []nums){
        if(start>end)
            return null;
        
        int mid=start+(end-start)/2;
        
        TreeNode node=new TreeNode(nums[mid]);
        //left subtree
        node.left=ArrayToBST(start,mid-1,nums);
        
        // rigth subtree
         node.right=ArrayToBST(mid+1,end,nums);
            return node;
    }
}