class Solution {
    public int minCapability(int[] nums, int k) {
        // Memoization -> MLE
        /*
        int[][] dp = new int[nums.length+1][k+1];
        for(int[] d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = solve(0, nums, k, dp);
        return ans;
        */

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for(int val : nums) {
            low = Math.min(low, val);
            high = Math.max(high, val);
        }
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            
            if(isPossible(mid, nums, k)) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int cap, int[] nums, int k) {
        int houses = 0;
        int i = 0;
        while(i<nums.length) {
            if(nums[i] <= cap) {
                houses++;
                i+=2;
            } else {
                i++;
            }
        }
        return houses >= k;
    }

    private int solve(int idx, int[] nums, int k, int[][] dp) {
        if(k == 0) {
            return 0;
        }
        if(idx >= nums.length) {
            return Integer.MAX_VALUE;
        }

        if(dp[idx][k] != -1) {
            return dp[idx][k];
        }

        // take 
        int take = Math.max(nums[idx], solve(idx+2, nums, k-1, dp));

        int notTake = solve(idx+1, nums, k, dp);

        return dp[idx][k] = Math.min(take, notTake);
    }
}