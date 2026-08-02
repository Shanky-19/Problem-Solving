class Solution {

    private int solve (int l, int r, int[] piles, int[][] dp) {
        if(l > r) {
            return 0;
        }

        if(dp[l][r] != -1) {
            return dp[l][r];
        }

        int leftChose = piles[l] + Math.min(solve(l+2, r, piles, dp), solve(l+1, r-1, piles, dp));
        int rightChose = piles[r] + Math.min(solve(l+1, r-1, piles, dp), solve(l, r-2, piles, dp));

        return dp[l][r] = Math.max(leftChose, rightChose);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int val : piles) {
            total += val;
        }
        
        int l = 0;
        int r = n-1;

        int[][] dp = new int[n][n];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }

        int aliceScore = solve(l, r, piles, dp);
        int bobScore = total - aliceScore;

        return aliceScore > bobScore;
    }
}