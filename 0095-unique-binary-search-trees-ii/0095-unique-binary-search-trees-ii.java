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
    public List<TreeNode> generateTrees(int n) {
        if(n>0){
       List<TreeNode> tree=constructtree(1,n);   
        return tree;
        }
        return Collections.emptyList();
        
    }
    static List<TreeNode> constructtree(int start,int end){
		List<TreeNode> list=new ArrayList<TreeNode>();
		
		if(start>end) {
			list.add(null);
			return list;
		}
		
		for(int i=start;i<=end;i++) {
			List<TreeNode> leftsubtree=constructtree(start,i-1);
			List<TreeNode> rightsubtree=constructtree(i+1,end);
			
			for(int j=0;j<leftsubtree.size();j++) {
				TreeNode left=leftsubtree.get(j);
				
				for(int k=0;k<rightsubtree.size();k++) {
					TreeNode right=rightsubtree.get(k);
					
					TreeNode node = new TreeNode(i);  
					node.left=left;
					node.right=right;
					
					list.add(node);
				}
			}
		}
		return list;
	}
}