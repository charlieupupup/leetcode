import java.util.Arrays;
import java.util.TreeMap;

/*
 * @lc app=leetcode id=945 lang=java
 *
 * [945] Minimum Increment to Make Array Unique
 */

// @lc code=start
class Solution {
    // public int minIncrementForUnique(int[] A) {
    // Arrays.sort(A);
    // int res = 0, need = 0;
    // for (int a : A) {
    // res += Math.max(need - a, 0);
    // need = Math.max(need, a) + 1;
    // }
    // return res;
    // }

    public int minIncrementForUnique(int[] A) {
        TreeMap<Integer, Integer> cnt = new TreeMap<>();
        for (int a : A) {
            cnt.put(a, cnt.getOrDefault(a, 0) + 1);
        }
        int res = 0, need = 0;
        for (int k : cnt.keySet()) {
            int v = cnt.get(k);
            res += v * Math.max(need - k, 0) + (v - 1) * v / 2;
            need = Math.max(need, k) + v;
        }
        return res;
    }
}
// @lc code=end
