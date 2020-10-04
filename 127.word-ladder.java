import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int len = 0;
        Queue<String> q = new LinkedList<>();
        Set<String> hs = new HashSet<>(wordList);
        q.offer(beginWord);
        while (!q.isEmpty()) {
            Queue<String> next = new LinkedList<>();
            len++;
            while (!q.isEmpty()) {
                String cur = q.poll();
                if (cur.equals(endWord)) {
                    return len;
                }
                char[] tmp = cur.toCharArray();
                for (int i = 0; i < tmp.length; i++) {
                    char t = tmp[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        tmp[i] = c;
                        String s = new String(tmp);
                        if (hs.contains(s)) {
                            next.offer(s);
                            hs.remove(s);
                        }
                    }
                    tmp[i] = t;
                }
            }
            q = next;
        }
        return 0;
    }
}
// @lc code=end
