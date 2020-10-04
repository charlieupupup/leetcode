import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=287 lang=java
 *
 * [287] Find the Duplicate Number
 */

// @lc code=start
class Solution {
    public int findDuplicate(int[] nums) {
        // int lo = 0, hi = nums.length - 1;
        // while (lo < hi) {
        // int mid = lo + (hi - lo) / 2;
        // int cnt = 0;
        // for (int n : nums) {
        // if (n <= mid) {
        // cnt++;
        // }
        // }
        // if (cnt > mid) {
        // hi = mid;
        // } else {
        // lo = mid + 1;
        // }
        // }
        // return lo;

        Set<Integer> hs = new HashSet<>();
        for (int n : nums) {
            if (!hs.add(n)) {
                return n;
            }
        }
        return -1;
    }
}
// @lc code=end
