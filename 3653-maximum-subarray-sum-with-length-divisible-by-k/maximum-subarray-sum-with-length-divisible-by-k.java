class Solution {
    public long maxSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long prefix = 0L;
        final long INF = (long)1e18;
        long[] minPre = new long[k];
        for (int i = 0; i < k; ++i) minPre[i] = INF;
        minPre[0] = 0L;
        long ans = -INF;
        for (int j = 1; j <= n; ++j) {
            prefix += nums[j-1];
            int r = j % k;
            if (minPre[r] != INF) {
                long cand = prefix - minPre[r];
                if (cand > ans) ans = cand;
            }
            if (prefix < minPre[r]) minPre[r] = prefix;
        }
        return ans;
    }
}