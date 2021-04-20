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
   class VerticalNode implements Comparable<VerticalNode> {
        
        TreeNode node;
        int x = 0;
        int level = 0;
        
        VerticalNode(TreeNode node, int x, int level) {
            
            this.node = node;
            this.x = x;
            this.level = level;
        }
        
        @Override
        public int compareTo(VerticalNode obj) {
            
            if (this.level == obj.level)
            return this.node.val - obj.node.val;
            
            return this.level - obj.level;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
                
        List<List<Integer>> result = new LinkedList<>();
        
        PriorityQueue<VerticalNode> queue = new PriorityQueue<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        
        queue.add(new VerticalNode(root, 0, 0));
        
        int level = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            
            while (size-- > 0) {
                
                VerticalNode vertNode = queue.poll();
                
                if (!map.containsKey(vertNode.x)) {
                    
                    map.put(vertNode.x, new LinkedList<>());
                }
                
                map.get(vertNode.x).add(vertNode.node.val);
                
                if (vertNode.node.left != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.left, 
                                               vertNode.x-1, level+1));
                }
                
                if (vertNode.node.right != null) {
                    
                    queue.add(new VerticalNode(vertNode.node.right, 
                                               vertNode.x+1, level+1));
                }
            }
            
            ++level;
        }
        
        for (List<Integer> list: map.values()) {
            
            result.add(list);
        } 
        
        return result;
    }
}