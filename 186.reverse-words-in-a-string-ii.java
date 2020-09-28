/*
 * @lc app=leetcode id=186 lang=java
 *
 * [186] Reverse Words in a String II
 */

// @lc code=start
class Solution {
    public void reverseWords(char[] s) {
        swap(s, 0, s.length - 1);
        int i = 0, j = 0;
        while (i < s.length) {
            j = i;
            while (j < s.length && s[j] != ' ') {
                j++;
            }
            swap(s, i, j - 1);
            i = j + 1;
        }
    }

    private void swap(char[] s, int lo, int hi) {
        while (lo < hi) {
            char t = s[lo];
            s[lo] = s[hi];
            s[hi] = t;
            lo++;
            hi--;
        }
    }
}
// @lc code=end
