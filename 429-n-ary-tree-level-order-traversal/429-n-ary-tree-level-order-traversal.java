/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
         List<List<Integer>> ans = new ArrayList<>();
        if (root==null) return ans;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        int size = 0;
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (size==0) {
                if (level.size()!=0) ans.add(level);
                size=queue.size();
                level = new ArrayList<>();
            }
            Node curr = queue.poll();
            size --;
            level.add(curr.val);
            if (curr.children.size()>0) {
                for (Node c: curr.children) {
                    queue.add(c);
                }
            }        
        }
        if (level.size()!=0) ans.add(level);
        return ans;
    }
}