class Solution {
    public int jump(int[] nums) {
        int idx = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans = helper(idx, n, nums, dp);
        return ans;
    }

    private int helper(int idx, int n, int[] nums, int[] dp) {
        if(idx == n-1) {
            return 0;
        }
        if(dp[idx] != -1) {
            return dp[idx];
        }
        int jumps = nums[idx];
        int ans = (int)1e9;
        for(int i=1;i<=jumps;i++) {
            if(idx+i <= n-1) {
                ans = Math.min(ans, 1 + helper(idx+i, n, nums, dp));
            }
        }
        return dp[idx] = ans;
    }
}