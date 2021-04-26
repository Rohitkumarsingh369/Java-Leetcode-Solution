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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths=new ArrayList<>();
        String path="";
        dfs(root,paths,path);
        return paths;
    }
    public void dfs(TreeNode root,List<String> paths,String path){
        if(!path.isBlank())
            path=path+"->";
        
        path=path+String.valueOf(root.val);
        
        if(root.left==null && root.right==null)
            paths.add(path);
        else if(root.left==null)
            dfs(root.right,paths,path);
        else if(root.right==null)
            dfs(root.left,paths,path);
        else{
            dfs(root.left,paths,path);
             dfs(root.right,paths,path);
        }
    }
}