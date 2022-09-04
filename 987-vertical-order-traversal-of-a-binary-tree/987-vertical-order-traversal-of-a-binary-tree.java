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
   Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        helper(0, 0, root);
        List<List<Integer>> lists = new ArrayList<>();
        for(Map.Entry<Integer, Map<Integer, List<Integer>>> m : map.entrySet()){
            List<Integer> col = new ArrayList<>();
            for(Map.Entry<Integer, List<Integer>> e : m.getValue().entrySet()){
                List<Integer> list = e.getValue();
                Collections.sort(list);
                col.addAll(list);
            }
            lists.add(col);
        }
        return lists;
    }

    void helper(int x, int y, TreeNode node){
        if(node==null) return;
        if(!map.containsKey(x)){
            map.put(x, new TreeMap<>());
        }
        
        if(!map.get(x).containsKey(y)){
            map.get(x).put(y, new ArrayList<>());
        }
        map.get(x).get(y).add(node.val);
        
        helper(x-1, y+1, node.left);
        helper(x+1, y+1, node.right);
    }
}