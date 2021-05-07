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
    public TreeNode deleteNode(TreeNode root, int key) {
         if(root == null) return root;
        if(key > root.val){ 
            root.right = deleteNode(root.right, key);
        }else if(key < root.val){ 
            root.left = deleteNode(root.left, key);
        }else{ 
            if(root.left == null && root.right == null){
                root = null;
            }else if(root.right != null){ 
                root.val = successor(root); // my worthy successor
                root.right = deleteNode(root.right, root.val);
            }else{ 
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }
   /* public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(key > root.val){ //move right
            root.right = deleteNode(root.right, key);
        }else if(key < root.val){ //move left
            root.left = deleteNode(root.left, key);
        }else{ //oh yes, we finally found the target
            if(root.left == null && root.right == null){ //hmm, its a leaf node; easy peasy
                root = null;
            }else if(root.right != null){ // oh, it has a right child, don't make it an orphan or is it old enough to become a parent ? lets find out
                root.val = successor(root); // my worthy successor
                root.right = deleteNode(root.right, root.val);
            }else{ //oh it seems that I do not have a worthy successor, fallback, fallback ...
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }*/
    private int successor(TreeNode root){
        root = root.right;
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
    
    private int predecessor(TreeNode root){
        root = root.left;
        while(root.right != null){
            root = root.right;
        }
        return root.val;
    }
}