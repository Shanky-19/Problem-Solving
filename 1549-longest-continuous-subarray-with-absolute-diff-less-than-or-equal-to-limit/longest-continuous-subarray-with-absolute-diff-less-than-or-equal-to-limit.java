//Approach-1 (Using sliding window + heap)
//T.C : O(nlogn)
//S.C : O(n)
class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        // max-heap
        PriorityQueue<int[]> maxPq = new PriorityQueue<>(
            (a, b) -> {
                return b[0] - a[0];
            }
        );
        // min-heap
        PriorityQueue<int[]> minPq = new PriorityQueue<>(
            (a, b) -> {
                return a[0] - b[0];
            }
        );

        int i = 0; // Left boundary of the sliding window
        int j = 0; // Right boundary of the sliding window
        int maxLength = 0;

        while (j < n) {
            maxPq.add(new int[]{nums[j], j});
            minPq.add(new int[]{nums[j], j});

            while (maxPq.peek()[0] - minPq.peek()[0] > limit) {
                i = Math.min(maxPq.peek()[1], minPq.peek()[1]) + 1;

                while (maxPq.peek()[1] < i) {
                    maxPq.remove();
                }
                while (minPq.peek()[1] < i) {
                    minPq.remove();
                }
            }

            // Update maxLength with the length of the current valid window
            maxLength = Math.max(maxLength, j - i + 1);
            j++;
        }

        return maxLength;
    }
}
