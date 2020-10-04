import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=146 lang=java
 *
 * [146] LRU Cache
 */

// @lc code=start
class Node {
    int key, val;
    Node prev, next;

    Node(int key, int val) {
        this.key = key;
        this.val = val;
        prev = null;
        next = null;
    }
}

class LRUCache {
    int cap, cnt;
    Map<Integer, Node> mp;
    Node head, tail;

    public LRUCache(int capacity) {
        cap = capacity;
        cnt = 0;
        mp = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    private void rm(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
        n.next = null;
        n.prev = null;
    }

    private void add(Node n) {
        n.prev = tail.prev;
        n.next = tail;

        tail.prev = n;
        n.prev.next = n;
    }

    public int get(int key) {
        if (!mp.containsKey(key)) {
            return -1;
        }
        Node n = mp.get(key);
        rm(n);
        add(n);
        return n.val;
    }

    public void put(int key, int value) {
        if (!mp.containsKey(key)) {
            Node n = new Node(key, value);
            add(n);
            mp.put(key, n);
            cnt++;
        } else {
            Node n = mp.get(key);
            n.val = value;
            rm(n);
            add(n);
        }

        if (cnt > cap) {
            Node n = head.next;
            mp.remove(n.key);
            rm(n);
            cnt--;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
