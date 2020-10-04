import java.util.LinkedList;
import java.util.Queue;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=104 lang=java
 *
 * [104] Maximum Depth of Binary Tree
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // public int maxDepth(TreeNode root) {
    // dep = 0;
    // Queue<TreeNode> q = new LinkedList<>();
    // if (root != null) {
    // q.offer(root);
    // }
    // while (!q.isEmpty()) {
    // Queue<TreeNode> next = new LinkedList<>();
    // while (!q.isEmpty()) {
    // TreeNode n = q.poll();
    // if (n.left != null) {
    // next.offer(n.left);
    // }
    // if (n.right != null) {
    // next.offer(n.right);
    // }
    // }
    // q = next;
    // dep++;
    // }
    // return dep;
    // }

}
// @lc code=end
