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
    public TreeNode buildTree(int[] in, int[] post) {
        return tree(in,0,in.length-1,post,0,post.length-1);
    }
   public TreeNode tree(int in[],int instart,int inend,int post[],int poststart,int postend) {
		if(poststart>postend || instart>inend)
			return null;
		
		int d=post[postend];
		
		int index=0;
		for(int i=instart;i<=inend;i++) {
			if(in[i]==d)
				index=i;
		}
		TreeNode root=new TreeNode(in[index]);
		/*if(instart==inend)
			return root;*/
		
		root.left=tree(in,instart,index-1,post,poststart,poststart+index-1-instart);
		root.right=tree(in,index+1,inend,post,poststart+index-instart,postend-1);
		return root;
	}
}