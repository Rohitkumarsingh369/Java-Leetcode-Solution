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
//     public List<Integer> rightSideView(TreeNode root) {
//         List<Integer> rightview=new ArrayList<>();
//         if(root==null)
// 			return rightview;
		
// 		Queue<TreeNode> q=new LinkedList<>();
// 		q.add(root);
// 		while(!q.isEmpty()) {
// 			int n=q.size();
// 			TreeNode temp=null;
// 			for(int i=1;i<=n;i++) {
// 				temp=q.poll();
// ;				if(i==1)
// 					rightview.add(temp.val);
			
//             if(temp.right!=null)
// 			    q.add(temp.right);
                
// 			if(temp.left!=null)
// 				q.add(temp.left);
			
// 			}
// 		}
//         return rightview;
//     }
    public List<Integer> rightSideView(TreeNode root) {
       List<Integer> result = new ArrayList<>();
        dfs(root, 0, result);
        return result;
    }
    private void dfs(TreeNode root,int depth,List<Integer> result){
        if(root==null){
            return;
        }
        
        if(depth==result.size()){
            result.add(root.val);
        }
        
        dfs(root.right,depth+1 ,result);
        dfs(root.left, depth+1, result);
    }
}
