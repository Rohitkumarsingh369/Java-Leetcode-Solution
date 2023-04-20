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
   record Pair(TreeNode node, int pos) {} // replace with class for Java < 14

public int widthOfBinaryTree(TreeNode root) {
	var q = new ArrayDeque<>(List.of(new Pair(root, 0)));
	var maxWidth = 1;

	while (!q.isEmpty()) {
		var head = q.peek();
		var tail = head;

		for (var i = q.size(); i > 0; i--) {
			tail = q.poll();
			if (tail.node.left != null)
				q.add(new Pair(tail.node.left, 2 * tail.pos));
			if (tail.node.right != null)
				q.add(new Pair(tail.node.right, 2 * tail.pos + 1));
		}
		maxWidth = Math.max(maxWidth, tail.pos - head.pos + 1);
	}
	return maxWidth;
}
}