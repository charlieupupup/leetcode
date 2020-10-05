import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 */

// @lc code=start
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
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        // postorderTraversal(root.left);
        // postorderTraversal(root.right);
        // res.add(root.val);
        // return res;
        if (root == null) {
            return res;
        }
        Stack<TreeNode> s = new Stack<>();
        s.push(root);
        while(!s.isEmpty()) {
            TreeNode cur = s.pop();
            if (cur == null) {
                continue;
            }
            res.add(0, cur.val);
            s.push(cur.left);
            s.push(cur.right);
        }
        return res;
    }


}
// @lc code=end

