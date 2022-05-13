/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(root == null){
		return null;
	}
    
    Queue<Node> q = new LinkedList<>();
    
    q.offer(root);
    
    while(!q.isEmpty()){
        int size = q.size();
        
        for(int i=0;i<size;i++){
            Node tmp = q.poll();
            
            if(tmp.left != null){
                q.offer(tmp.left);
            }
            if(tmp.right != null){
                q.offer(tmp.right);
            }
            
            if (i < size - 1) {
                tmp.next = q.peek();
            }
            else {
                tmp.next = null;
            }
        }    
    }
    
    return root;
    }
}