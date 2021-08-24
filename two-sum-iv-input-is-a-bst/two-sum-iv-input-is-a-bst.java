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
    public boolean findTarget(TreeNode root, int k) {
        
        ArrayList<Integer> list=new ArrayList<>();
        
        inorder(root,list);
        
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<list.size();i++){
            if(set.contains(k-list.get(i)))
                return true;
            
            else
                set.add(list.get(i));
        }
        return false;
    }
    
    public void inorder(TreeNode root,ArrayList<Integer> list){
        if(root!=null){
            inorder(root.left,list);
            list.add(root.val);
            inorder(root.right,list);
        }
    }
    
}