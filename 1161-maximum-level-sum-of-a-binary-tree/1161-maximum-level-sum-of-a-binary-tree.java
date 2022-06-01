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
    public int maxLevelSum(TreeNode root) {
        if(root==null)
            return 0;
        
        int max=Integer.MIN_VALUE;
        int resultlevel=0,level=0;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            
            int size=queue.size();
            int sum=0;
            while(size-->0){
                TreeNode temp=queue.poll();
                sum+=temp.val;
                if(temp.left!=null)
                    queue.add(temp.left);
                
                if(temp.right!=null)
                    queue.add(temp.right);
            }
            if(sum>max){
                max=sum;
                resultlevel=level+1;
            }
            ++level;
        }
       // System.out.println(max);
        return resultlevel;
    }
}