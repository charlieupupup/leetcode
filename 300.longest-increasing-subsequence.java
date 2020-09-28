
/*
 * @lc app=leetcode id=300 lang=java
 *
 * [300] Longest Increasing Subsequence
 */

// @lc code=start
/* class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        // find the biggest
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }

        return res;
    }
}
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] top = new int[nums.length];

        int piles = 0;

        for (int curr : nums) {

            // find smallest left bound
            int left = 0, right = piles;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (top[mid] == curr) {
                    right = mid - 1;
                } else if (top[mid] < curr) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (left <= piles) {
                top[left] = curr;
            } else {
                top[left - 1] = curr;
            }

            // check find bound
            if (left >= piles) {
                piles++;
            }

        }

        return piles;
    }
}
// @lc code=end
