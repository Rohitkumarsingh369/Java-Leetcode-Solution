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
    Map<Integer,Integer> map = new HashMap();
    int mostFreq = 0;
    
    public int[] findFrequentTreeSum(TreeNode root) {
        postorder(root);
        
        ArrayList<Integer> temp = new ArrayList();
        for(int i : map.keySet()){
            if(map.get(i) == mostFreq)temp.add(i); 
        }
        
        int []res = new int[temp.size()];
        for(int i = 0;i< temp.size();i++){
            res[i] = temp.get(i);
        }
        return res;
    }
    
    public int postorder(TreeNode root){
        if(root == null)return 0;
        
        int left = postorder(root.left);
        int right = postorder(root.right);      
        int sum = left + right + root.val;
        
        map.put(sum,map.getOrDefault(sum,0) + 1);
        mostFreq = Math.max(mostFreq,map.get(sum));
        
        return sum;
    }
}