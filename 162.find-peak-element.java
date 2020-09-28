/*
 * @lc app=leetcode id=162 lang=java
 *
 * [162] Find Peak Element
 */

// @lc code=start
class Solution {
    // public int findPeakElement(int[] nums) {
    // for (int i = 1; i < nums.length; i++) {
    // if (nums[i] < nums[i - 1]) {
    // return i - 1;
    // }
    // }
    // return nums.length - 1;
    // }

    public int findPeakElement(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            int m1 = lo + (hi - lo) / 2;
            int m2 = m1 + 1;
            if (nums[m1] < nums[m2]) {
                lo = m1 + 1;
            } else {
                hi = m2 - 1;
            }
        }
        return lo;
    }

}
// @lc code=end
