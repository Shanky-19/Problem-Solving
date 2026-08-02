class Solution {

    private int solve (int l, int r, int[] nums, int[][] dp) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        int leftChose = nums[l] 
                        + Math.min(
                                solve(l+2, r, nums, dp), 
                                solve(l+1, r-1, nums, dp)
                            );

        int rightChose = nums[r] 
                        + Math.min(
                            solve(l, r-2, nums, dp), 
                            solve(l+1, r-1, nums, dp)
                        );

        return dp[l][r] = Math.max(leftChose, rightChose);
    }

    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        if (n % 2 == 0) {
            return true;
        }
        
        int total = 0;
        for(int val : nums) {
            total += val;
        }
        
        int l = 0;
        int r = n-1;

        int[][] dp = new int[n][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int player1Score = solve(l, r, nums, dp);
        int player2Score = total - player1Score;

        return player1Score >= player2Score;
    }
}