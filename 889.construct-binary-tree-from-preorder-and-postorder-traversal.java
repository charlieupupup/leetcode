import java.util.Deque;
import java.util.LinkedList;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=889 lang=java
 *
 * [889] Construct Binary Tree from Preorder and Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    int preIndex = 0, posIndex = 0;

    // public TreeNode constructFromPrePost(int[] pre, int[] post) {
    // TreeNode root = new TreeNode(pre[preIndex]);
    // preIndex++;
    // if (root.val != post[posIndex]) {
    // root.left = constructFromPrePost(pre, post);
    // }
    // if (root.val != post[posIndex]) {
    // root.right = constructFromPrePost(pre, post);
    // }
    // posIndex++;
    // return root;
    // }

    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        Deque<TreeNode> s = new LinkedList<>();
        s.offer(new TreeNode(pre[0]));
        for (int i = 1, j = 0; i < pre.length; ++i) {
            TreeNode node = new TreeNode(pre[i]);
            while (s.getLast().val == post[j]) {
                s.pollLast();
                j++;
            }
            if (s.peekLast().left == null) {
                s.peekLast().left = node;
            } else {
                s.peekLast().right = node;
            }
            s.offer(node);
        }
        return s.peekFirst();
    }
}
// @lc code=end
