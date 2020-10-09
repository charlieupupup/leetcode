import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode id=106 lang=java
 *
 * [106] Construct Binary Tree from Inorder and Postorder Traversal
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    // Map<Integer, Integer> hm = new HashMap<Integer, Integer>();

    // public TreeNode buildTree(int[] inorder, int[] postorder) {
    // for (int i = 0; i < inorder.length; i++) {
    // hm.put(inorder[i], i);
    // }
    // return buildTree(inorder, 0, inorder.length - 1, postorder, 0,
    // postorder.length - 1);
    // }

    // private TreeNode buildTree(int[] inorder, int is, int ie, int[] postorder,
    // int ps, int pe) {
    // if (ps > pe || is > ie) {
    // return null;
    // }
    // TreeNode root = new TreeNode(postorder[pe]);
    // int ri = hm.get(postorder[pe]);
    // TreeNode left = buildTree(inorder, is, ri - 1, postorder, ps, ps + ri - is -
    // 1);
    // TreeNode right = buildTree(inorder, ri + 1, ie, postorder, ps + ri - is, pe -
    // 1);
    // root.left = left;
    // root.right = right;
    // return root;
    // }

    int ptrIn; // index of inorder array
    int prtPo; // index of postorder array

    private TreeNode buildTree(int[] inorder, int[] postorder, TreeNode end) {
        if (prtPo < 0) {
            return null;
        }

        // create root node
        TreeNode n = new TreeNode(postorder[prtPo]);
        prtPo--;

        // if right node exist, create right subtree
        if (inorder[ptrIn] != n.val) {
            n.right = buildTree(inorder, postorder, n);
        }

        ptrIn--;

        // if left node exist, create left subtree
        if (end == null || inorder[ptrIn] != end.val) {
            n.left = buildTree(inorder, postorder, end);
        }

        return n;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        ptrIn = inorder.length - 1;
        prtPo = postorder.length - 1;

        return buildTree(inorder, postorder, null);
    }

}
// @lc code=end
