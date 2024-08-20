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
    public boolean isBalanced(TreeNode root) {
       // return checkHeight(root)!=-1;
        
        //iterative 
        if (root == null) return true;

        // Stack to hold nodes for processing
        Stack<TreeNode> stack = new Stack<>();
        // Map to store the height of nodes
        Map<TreeNode, Integer> heightMap = new HashMap<>();

        TreeNode currentNode = root;
        TreeNode lastVisited = null;

        // Process all nodes
        while (!stack.isEmpty() || currentNode != null) {
            if (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            } else {
                TreeNode nodeOnTop = stack.peek();
                if (nodeOnTop.right != null && lastVisited != nodeOnTop.right) {
                    currentNode = nodeOnTop.right;
                } else {
                    stack.pop();
                    int leftHeight = heightMap.getOrDefault(nodeOnTop.left, 0);
                    int rightHeight = heightMap.getOrDefault(nodeOnTop.right, 0);

                    if (Math.abs(leftHeight - rightHeight) > 1) {
                        return false; // The tree is not balanced
                    }

                    heightMap.put(nodeOnTop, 1 + Math.max(leftHeight, rightHeight));
                    lastVisited = nodeOnTop;
                }
            }
        }
        return true;
    }
    private int checkHeight(TreeNode root){
        if(root==null){
            return 0;
        }
        
        int leftHeight=checkHeight(root.left);
        if(leftHeight==-1){
            return -1;
        }
        
        int rightHeight=checkHeight(root.right);
        if(rightHeight==-1){
            return -1;
        }
        
        if(Math.abs(leftHeight-rightHeight)>1){
            return -1;
        }
        
        return Math.max(leftHeight,rightHeight)+1;
    }
}