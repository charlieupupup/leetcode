import java.util.Arrays;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode id=253 lang=java
 *
 * [253] Meeting Rooms II
 */

// @lc code=start
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[1] - b[1]));
        for (int[] i : intervals) {
            if (pq.isEmpty()) {
                pq.offer(new int[] { i[0], i[1] });
            } else {
                int[] cur = pq.peek();
                if (cur[1] <= i[0]) {
                    cur = pq.poll();
                    cur[1] = i[1];
                    pq.offer(cur);
                } else {
                    pq.offer(new int[] { i[0], i[1] });
                }
            }
        }
        return pq.size();
    }
}
// @lc code=end
