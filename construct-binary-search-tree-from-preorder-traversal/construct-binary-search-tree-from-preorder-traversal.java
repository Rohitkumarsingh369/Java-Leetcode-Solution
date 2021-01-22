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
    public TreeNode bstFromPreorder(int[] pre) {
        return construct(pre,0,pre.length-1);
    }
    static TreeNode construct(int pre[],int start,int end){
        if(start>end)
            return null;
        
        TreeNode root=new TreeNode(pre[start]);
        
        int i;
        for(i=start+1;i<=end;i++){
            if(pre[i]>root.val)
                break;
        }
        root.left=construct(pre,start+1,i-1);
        root.right=construct(pre,i,end);
        
        //return the root
        return root;
    }
}
