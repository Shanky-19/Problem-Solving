class Solution {
    public long maxKelements(int[] nums, int k) {
        long ans = 0L;

        PriorityQueue<Integer> pq = 
            new PriorityQueue<>(Collections.reverseOrder());

        for(int val : nums) {
            pq.add(val);
        }

        while(k-- > 0) {
            int val = pq.remove();

            ans += val;
            pq.add((int)Math.ceil((val*1.0)/3));
        }

        return ans;
    }
}