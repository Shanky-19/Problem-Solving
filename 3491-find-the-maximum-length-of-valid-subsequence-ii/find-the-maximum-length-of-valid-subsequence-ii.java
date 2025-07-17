class Solution {
    public int maximumLength(int[] nums, int k) {
        // int ans = 0;
        // int n = nums.length;
        // for(int i=0;i<k;i++) {
        //     int possibleValue = i;
        //     int[][] dp = new int[n][n];
        //     for(int j=0;j<n;j++) {
        //         Arrays.fill(dp[j], -1);
        //     }
        //     ans = Math.max(ans, findMaxLengthSubsequence(nums, k, possibleValue, 0, -1, dp));
        // }
        // return ans;

        int[][] dp = new int[k][k];
        int res = 0;
        for (int num : nums) {
            num %= k;
            for (int prev = 0; prev < k; prev++) {
                dp[prev][num] = dp[num][prev] + 1;
                res = Math.max(res, dp[prev][num]);
            }
        }
        return res;

    }

    private int findMaxLengthSubsequence(int[] nums, int k, int val, 
    int idx, int prevSelectedIdx, int[][] dp) {
        if(idx == nums.length) {
            return 0;
        }

        if(dp[idx][prevSelectedIdx+1] != -1) {
            return dp[idx][prevSelectedIdx+1];
        }
        
        // pick
        int ans1 = 0;
        if(prevSelectedIdx == -1) {
            ans1 = 1 + findMaxLengthSubsequence(nums, k, val, idx+1, idx, dp);
        } else {
            if((nums[idx] + nums[prevSelectedIdx])%k == val) {
                ans1 = 1 + findMaxLengthSubsequence(nums, k, val, idx+1, idx, dp);
            }
        }

        // not pick
        int ans2 = findMaxLengthSubsequence(nums, k, val, idx+1, prevSelectedIdx, dp);

        return dp[idx][prevSelectedIdx+1] = Math.max(ans1, ans2);
    }
}