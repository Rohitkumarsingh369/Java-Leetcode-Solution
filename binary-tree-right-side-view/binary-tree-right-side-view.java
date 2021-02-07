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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightview=new ArrayList<>();
        if(root==null)
			return rightview;
		
		Queue<TreeNode> q=new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			int n=q.size();
			TreeNode temp=null;
			for(int i=1;i<=n;i++) {
				temp=q.poll();
;				if(i==n)
					rightview.add(temp.val);
			
			if(temp.left!=null)
				q.add(temp.left);
			
			if(temp.right!=null)
				q.add(temp.right);
			}
		}
        return rightview;
    }
}