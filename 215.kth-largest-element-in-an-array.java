/*
 * @lc app=leetcode id=215 lang=java
 *
 * [215] Kth Largest Element in an Array
 */

// @lc code=start
class Solution {
    // public int findKthLargest(int[] nums, int k) {
    // PriorityQueue<Integer> pq = new PriorityQueue<>();
    // for (int n : nums) {
    // pq.offer(n);
    // if (pq.size() > k) {
    // pq.poll();
    // }
    // }
    // return pq.peek();
    // }

    public int findKthLargest(int[] nums, int k) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int p = quick(nums, lo, hi);
            if (p == k - 1) {
                return nums[p];
            } else if (p > k - 1) {
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
        return -1;
    }

    private int quick(int[] nums, int lo, int hi) {
        int pivot = nums[lo];
        while (lo < hi) {
            while (lo < hi && nums[hi] <= pivot) {
                hi--;
            }
            nums[lo] = nums[hi];
            while (lo < hi && nums[lo] >= pivot) {
                lo++;
            }
            nums[hi] = nums[lo];
        }
        nums[lo] = pivot;
        return lo;
    }
}
// @lc code=end
