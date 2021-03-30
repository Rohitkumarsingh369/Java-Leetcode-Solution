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
    public boolean isCompleteTree(TreeNode root) {
        
        //if root is null
        if(root==null)
            return true;
        boolean flag=false;
        Queue<TreeNode> queue=new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            TreeNode tempnode=queue.remove();
            
            
            //left subpart of the root
            if(tempnode.left!=null){
                if(flag==true)
                    return false;
                queue.add(tempnode.left);
            }
            else
                flag=true;
            
            //right subpart of the root
             if(tempnode.right!=null){
                if(flag==true)
                    return false;
                queue.add(tempnode.right);
            }
            else
                flag=true;
        }
        return true;
    }
}