/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution 
{
    int preindex=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) 
    {
        preindex=0;
        return buildtreehelper(preorder,inorder,0,preorder.length-1);
        
    }
    
    public TreeNode buildtreehelper(int[] preorder,int[] inorder,int start,int end)
    {
        if(start>end)
        {
            return null;
        }
        int key=preorder[preindex];
        preindex++;
        TreeNode root=new TreeNode(key);
        
        int isearch=search(inorder,start,end,root.val);
        
        root.left=buildtreehelper(preorder,inorder,start,isearch-1);
        root.right=buildtreehelper(preorder,inorder,isearch+1,end);
        return root;
    }
    
    public int search(int[] arr,int start,int end,int k)
    {
        for(int i=start;i<=end;i++)
        {
            if(arr[i]==k)
            {
                return i;
            }
        }
        return -1;
    }
}
