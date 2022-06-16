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
/*class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
       if(root==null)
           return false;
        
        if(root.left==null && root.right==null && targetSum==root.val)
            return true;
        
        return hasPathSum(root.left,targetSum-root.val)||hasPathSum(root.right,targetSum-root.val);
    }
    
}*/
class Solution {
public boolean hasPathSum(TreeNode root, int targetSum) {
if (root==null) return false;
Stack<TreeNode> stack = new Stack<>();
Stack<Integer> sum_stack = new Stack<>();
stack.push(root);
sum_stack.push(targetSum-root.val);

    while(!stack.isEmpty()){
        TreeNode temp_node = stack.pop();
        int current_sum = sum_stack.pop();
        
        if (current_sum==0 && temp_node.left==null && temp_node.right==null){
            return true;
        }
        
        if (temp_node.right!=null){
            stack.push(temp_node.right);
            sum_stack.push(current_sum-temp_node.right.val);
        }
        if (temp_node.left!=null){
            stack.push(temp_node.left);
            sum_stack.push(current_sum-temp_node.left.val);
        }
    }
    
    return false;
}
}