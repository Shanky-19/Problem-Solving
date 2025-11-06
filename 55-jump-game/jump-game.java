class Solution {
    public boolean canJump(int[] nums) {
        int idx = 0;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        boolean ans = helper(idx, n, nums, dp);
        return ans;
    }

    private boolean helper (int idx, int n, int[] nums, int[] dp) {
        if(idx == n-1) {
            return true;
        }

        if(dp[idx] != -1) {
            return dp[idx] == 1 ? true : false;
        }

        int jumps = nums[idx];
        for(int i=1;i<=jumps;i++) {
            boolean temp = helper(idx+i, n, nums, dp);
            if(temp) {
                dp[idx] = 1;
                return true;
            }
        }
        dp[idx]=0;
        return false;
    }
}