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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0,0,inorder.length-1,preorder,inorder);
    }
    public TreeNode helper(int prestart,int instart,int inend,int[] preorder,int []inorder){
        if(prestart>preorder.length-1|| instart>inend){
            return null;
        }
        
        TreeNode root=new TreeNode(preorder[prestart]);
        
        int inindex=0;
        
        for(int i=instart;i<=inend;i++){
            if(inorder[i]==root.val){
                inindex=i;
            }
        }
        
        root.left=helper(prestart+1,instart,inindex-1,preorder,inorder);
        
        root.right=helper(prestart+1+inindex-instart,inindex+1,inend,preorder,inorder);
        
        return root;
    }
}