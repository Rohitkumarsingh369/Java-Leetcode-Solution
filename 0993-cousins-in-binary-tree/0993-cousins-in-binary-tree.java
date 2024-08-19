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
    
    
    public boolean isCousins(TreeNode root, int x, int y) {
        if (root == null) return false;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean foundX = false, foundY = false;
            
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                
                // Check if x and y are children of the same parent
                if (node.left != null && node.right != null) {
                    if ((node.left.val == x && node.right.val == y) || 
                        (node.left.val == y && node.right.val == x)) {
                        return false; // Same parent, not cousins
                    }
                }
                
                // Check if we've found x or y
                if (node.val == x) foundX = true;
                if (node.val == y) foundY = true;
                
                // Add children to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            // If both x and y are found at the same level, they are cousins
            if (foundX && foundY) return true;
            
            // If only one of them is found, they can't be cousins
            if (foundX || foundY) return false;
        }
        
        return false;
    }
}