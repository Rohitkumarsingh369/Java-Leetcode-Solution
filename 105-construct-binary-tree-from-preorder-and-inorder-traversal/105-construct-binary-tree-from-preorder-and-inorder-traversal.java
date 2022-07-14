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
     int preindex=0;
   
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preindex=0;
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        for(int i=0;i<inorder.length;i++)
            hm.put(inorder[i],i);
        
       return  buildtree(preorder,inorder,0,preorder.length-1,hm);
    }
    public TreeNode buildtree(int [] preorder,int [] inorder,int start,int end,HashMap<Integer,Integer> hm){
        if(start>end)
            return null;
        
        
        int inindex=hm.get(preorder[preindex++]);
        
        TreeNode root=new TreeNode(inorder[inindex]);
        
        root.left=buildtree(preorder,inorder,start,inindex-1,hm);
        root.right=buildtree(preorder,inorder,inindex+1,end,hm);
        
        return root;
    }
}