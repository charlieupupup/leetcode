import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int lo = 0, hi = 0, len = 0;
        Set<Character> hs = new HashSet<>();
        while (hi < s.length()) {
            if (!hs.contains(s.charAt(hi))) {
                hs.add(s.charAt(hi));
                hi++;
                len = Math.max(len, hi - lo);
            } else {
                hs.remove(s.charAt(lo));
                lo++;
            }
        }
        return len;
    }
}
// @lc code=end
