class Solution {
    private int helper(int[] nums, int i, int j, int k, int[][] dp) {
        if(i == j) {
            return 0;
        }
        long min = nums[i];
        long max = nums[j];
        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        if(max > min * k) {
            // remove from front -> remove min
            int ans1 = 1 + helper(nums, i+1, j, k, dp);
            int ans2 = 1 + helper(nums, i, j-1, k, dp);

            return dp[i][j] = Math.min(ans1, ans2);
        } 
        return dp[i][j] = 0;

    }

    public int minRemoval(int[] nums, int k) {
        // int n = nums.length;
        // Arrays.sort(nums);
        // int[][] dp = new int[n][n];
        // int i = 0;
        // int j = n-1;
        // for(int[] arr : dp) {
        //     Arrays.fill(arr, -1);
        // }
        // int ans = helper(nums, i, j, k, dp);
        // return ans;

        // Intuition
        /*
            The problem asks for the minimum number of removals to satisfy the condition max≤min×k. 
            This is equivalent to finding the maximum number of elements we can keep. 
            If we sort the array, any subset of elements that satisfies the condition will form 
            a contiguous subarray. For any subarray starting at index i and ending at index j (where i≤j), 
            the minimum is nums[i] and the maximum is nums[j]. Thus, the problem simplifies to finding 
            the longest subarray where nums[j]≤nums[i]×k in a sorted array.
        */
        Arrays.sort(nums);
        int i = 0;
        int maxLen = 0;
        for (int j = 0; j < nums.length; j++) {
            // Use long to prevent integer overflow for nums[i] * k
            while ((long) nums[j] > (long) nums[i] * k) {
                i++;
            }
            maxLen = Math.max(maxLen, j - i + 1);
        }
        return nums.length - maxLen;
    }
}