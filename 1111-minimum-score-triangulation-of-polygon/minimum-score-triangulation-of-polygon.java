class Solution {
    public int minScoreTriangulation(int[] values) {
        int n = values.length;
        int[][] dp = new int[51][51];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        return solve (values, 0, n-1, dp);
    }

    private int solve (int[] values, int i, int j, int[][] dp) {
        if(j - i + 1 < 3) {
            return dp[i][j] = 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++) {
            int res = solve(values, i, k, dp) + 
                    (values[i] * values[j] * values[k]) 
                    + solve(values, k, j, dp);

            ans = Math.min(ans, res);
        }
        return dp[i][j] = ans;
    }
}