/*
 * @lc app=leetcode id=155 lang=java
 *
 * [155] Min Stack
 */

// @lc code=start
class Pair {
    int val, preM;

    Pair(int val, int preM) {
        this.val = val;
        this.preM = preM;
    }
}

// class MinStack {
// int min;
// Stack<Pair> s;

// /** initialize your data structure here. */
// public MinStack() {
// min = Integer.MAX_VALUE;
// s = new Stack<>();
// }

// public void push(int x) {
// Pair p = new Pair(x, min);
// s.push(p);
// min = Math.min(x, min);
// }

// public void pop() {
// Pair p = s.pop();
// if (p.val == min) {
// min = p.preM;
// }
// }

// public int top() {
// return s.peek().val;
// }

// public int getMin() {
// return min;
// }
// }
class Node {
    int val, min;
    Node prev;

    Node(int val, int min, Node prev) {
        this.val = val;
        this.min = min;
        this.prev = prev;
    }
}

class MinStack {
    Node tail;

    /** initialize your data structure here. */
    public MinStack() {
        tail = new Node(Integer.MAX_VALUE, Integer.MAX_VALUE, null);
    }

    public void push(int x) {
        Node n = new Node(x, Math.min(x, tail.min), tail);
        tail = n;
    }

    public void pop() {
        tail = tail.prev;
    }

    public int top() {
        return tail.val;
    }

    public int getMin() {
        return tail.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
// @lc code=end
