class Solution {
    public int lengthOfLIS(int[] nums) {
        // int idx = 0;
        // int prev = -1;
        // int[][] dp = new int[nums.length][nums.length];
        // for(int i=0;i<nums.length;i++) {
        //     Arrays.fill(dp[i], -1);
        // }
        // int ans = helper(nums, idx, prev, dp);
        // return ans;



        // Tabulation
        // 1. Create same dimension dp
        // 2. Create Base case 
        // 2. Represent problem in indexes
        // 3. copy the recurrence

        int[][] dp = new int[nums.length+1][nums.length+1];
        for(int i=nums.length-1;i>=0;i--){
            for(int prevIdx=i-1;prevIdx>=-1;prevIdx--){
                int len = dp[i+1][prevIdx+1];
                if(prevIdx == -1 || nums[i] > nums[prevIdx]){
                    len = Math.max(len,1 + dp[i+1][i+1]);
                }
                dp[i][prevIdx+1] = len;
            }
        }
        return dp[0][-1 + 1];
        

    }

    private int helper(int[] nums, int idx, int prev, int[][] dp) {
        if(idx == nums.length) {
            return 0;
        }

        if(dp[idx][prev+1] != -1) {
            return dp[idx][prev+1];
        }

        if(prev == -1) {
            int pick = 1 + helper(nums, idx+1, idx, dp);
            int notPick = helper(nums, idx+1, prev, dp);
            return dp[idx][prev+1] = Math.max(pick, notPick);
        } else {
            int pick = 0;
            if(nums[prev] < nums[idx]) {
                pick = 1 + helper(nums, idx+1, idx, dp);
            }
            int notPick = helper(nums, idx+1, prev, dp);
            return dp[idx][prev+1] = Math.max(pick, notPick);
        }

    }
}