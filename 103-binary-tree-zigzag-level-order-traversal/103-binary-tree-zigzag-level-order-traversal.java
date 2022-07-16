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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
            if (root == null) return res;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            boolean zigzag = false;
            while (!queue.isEmpty()) {
                List<Integer> level = new ArrayList<>();
                int cnt = queue.size();
                for (int i = 0; i < cnt; i++) {
                    TreeNode node = queue.poll();
                    if (zigzag) {
                        level.add(0, node.val);
                    }
                    else {
                        level.add(node.val);
                    }
                    if (node.left != null) {
                        queue.add(node.left);
                    }
                    if (node.right != null) {
                        queue.add(node.right);
                    }
                }
                
               
                res.add(level);
                zigzag = !zigzag;
            }
            return res;
    }
}