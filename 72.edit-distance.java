import java.util.*;

/*
 * @lc app=leetcode id=72 lang=java
 *
 * [72] Edit Distance
 */

/**
 * recursive + memo
 */
// @lc code=start

class Solution {
    Map<List, Integer> memo = new HashMap<>();

    private int helper(int i, int j, String word1, String word2) {
        if (i == -1) {
            return j + 1;
        }

        if (j == -1) {
            return i + 1;
        }

        if (word1.charAt(i) == word2.charAt(j)) {
            return helper(i - 1, j - 1, word1, word2);
        }

        List curr = new ArrayList<Integer>(Arrays.asList(i, j));

        if (memo.containsKey(curr)) {
            return memo.get(curr);
        }
        int tmp = Math.min(helper(i - 1, j, word1, word2) + 1, helper(i, j - 1, word1, word2) + 1);
        int res = Math.min(tmp, helper(i - 1, j - 1, word1, word2) + 1);
        memo.put(curr, res);
        return res;

    }

    public int minDistance(String word1, String word2) {
        return helper(word1.length() - 1, word2.length() - 1, word1, word2);

    }
}

// @lc code=end
