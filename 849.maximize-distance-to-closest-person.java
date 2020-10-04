/*
 * @lc app=leetcode id=849 lang=java
 *
 * [849] Maximize Distance to Closest Person
 */

// @lc code=start
class Solution {
    public int maxDistToClosest(int[] seats) {
        int res = 0, last = -1;
        for (int i = 0; i < seats.length; i++) {
            if (seats[i] == 1) {
                res = last == -1 ? i : Math.max(res, (i - last) / 2);
                last = i;
            }
        }
        res = Math.max(res, seats.length - 1 - last);
        return res;
    }
}
// @lc code=end
