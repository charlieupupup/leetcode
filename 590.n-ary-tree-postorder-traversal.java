import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @lc app=leetcode id=590 lang=java
 *
 * [590] N-ary Tree Postorder Traversal
 */

// @lc code=start
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
    List<Integer> res = new ArrayList<>();
    // public List<Integer> postorder(Node root) {
    // if (root == null) {
    // return res;
    // }

    // for (Node c : root.children) {
    // postorder(c);
    // }

    // res.add(root.val);
    // return res;
    // }
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return list;

        Stack<Node> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            list.add(0, root.val);
            for (Node c : root.children) {
                stack.add(c);
            }
        }

        return list;
    }
}
// @lc code=end
