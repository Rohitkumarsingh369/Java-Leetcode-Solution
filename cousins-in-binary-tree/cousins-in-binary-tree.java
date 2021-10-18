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
    public static boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) return false;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode xParent = null, yParent = null;
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size > 0){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    if(node.left.val == x) xParent = node;
                    if(node.left.val == y) yParent = node;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    if(node.right.val == x) xParent = node;
                    if(node.right.val == y) yParent = node;
                }
                --size;
                if(xParent != null && yParent != null) break;
            }
            if(xParent != null && yParent != null) return xParent != yParent;
            if((xParent != null && yParent == null) || 
               (xParent == null && yParent != null)) return false;
            
        }
        return false;
    }
}