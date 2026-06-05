class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int val : nums) {
            pq.add(1L * val);
        }
        int ans = 0;
        while(pq.size() > 1 && pq.peek() < k) {
            long x = pq.remove();
            long y = pq.remove();
            pq.add(1L * 2 * x + y);
            ans++;
        }
        return ans;
    }
}