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
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)
            return new ArrayList<>();
        
        Queue<TreeNode> q=new LinkedList<>();
        List<Integer> list=new ArrayList<>();
        int max;
        q.add(root);
        while(!q.isEmpty()){
            max=Integer.MIN_VALUE;
            int len=q.size();
            for(int i=0;i<len;i++){
                TreeNode temp=q.peek();
                q.remove();
                max=Math.max(max,temp.val);
                if(temp.left!=null)
                    q.add(temp.left);
                if(temp.right!=null)
                    q.add(temp.right);
            }
            list.add(max);
            
        }
        return list;
    }
}