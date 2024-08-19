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
    public List<List<Integer>> levelOrder(TreeNode root) {
       List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        
        Queue<TreeNode> q=new LinkedList<>();
        
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            
            List<Integer> level=new ArrayList<>();
            
            while(size-->0){
                root=q.poll();
                level.add(root.val);
                
                if(root.left!=null){
                    q.add(root.left);
                }
                if(root.right!=null){
                    q.add(root.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}