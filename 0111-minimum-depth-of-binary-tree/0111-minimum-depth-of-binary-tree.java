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
    public int minDepth(TreeNode root) {
       /*  if(root == null) {
            return 0;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int minDepth = 1;
        
        while(queue.size() != 0) {
            TreeNode front = queue.poll();
            if(front == null) {
                if(queue.size() == 0)
                    break;
                
                minDepth++;
                queue.add(null);
            }
            else {
                if(front.left == null && front.right == null)
                    break;
                if(front.left != null)
                    queue.add(front.left);
                if(front.right != null)
                    queue.add(front.right);
            }
        }
        return minDepth;*/
        
        if(root == null) return 0;
        int left = minDepth(root.left);
        int right = minDepth(root.right);
        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
    }
    
}