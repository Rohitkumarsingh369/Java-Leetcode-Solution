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
    public List<List<String>> printTree(TreeNode root) {
        int row=depth(root);
        int col=(int)Math.pow(2,row)-1;
        int mid=col/2;
        List<List<String>> result=new ArrayList();
        List<String> list=new ArrayList(Collections.nCopies(col,""));
        for(int i=0;i<row;i++){
            result.add(new ArrayList(list));
        }
        
        pre(root,0,mid,col/2,result);
        return result;
    }
    public void pre(TreeNode root,int row,int col,int half,List<List<String>>result){
        if(root==null)
            return;
        
        result.get(row).set(col,""+root.val);
        pre(root.left,row+1,col-half/2-1,half/2,result);
        pre(root.right,row+1,col+half/2+1,half/2,result);
    }
    public int depth(TreeNode root){
        if(root==null)
            return 0;
        
        return 1+Math.max(depth(root.left),depth(root.right));
    }
}