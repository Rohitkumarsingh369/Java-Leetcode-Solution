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
    public List<Double> averageOfLevels(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        
        List<Double> result=new ArrayList<>();
            
            while(!q.isEmpty()){
                int n=q.size();
                Long sum=0L;
                for(int i=0;i<n;i++){
                    TreeNode temp=q.poll();
                    sum+=temp.val;
                    
                    if(temp.left!=null)
                        q.add(temp.left);
                    if(temp.right!=null)
                        q.add(temp.right);
                }
                double avg=(double)sum/n;
                result.add(avg);
            }
        return result;
    }
}