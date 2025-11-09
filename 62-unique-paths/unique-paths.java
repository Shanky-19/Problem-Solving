class Solution {
    public int uniquePaths(int m, int n) {
        int r = m-1;
        int c = n-1;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = helper(r, c, m, n, dp);
        return ans;
    }

    private int helper(int r, int c, int m, int n, int[][] dp) {
        if(r == 0 && c == 0) {
            return 1;
        }
        if(dp[r][c] != -1) {
            return dp[r][c];
        }
        int up = 0;
        int left = 0;
        if(r-1 >= 0) {
            up = helper(r-1, c, m, n, dp);
        }
        if(c-1 >= 0) {
            left = helper(r, c-1, m, n, dp);
        }

        return dp[r][c] = up + left;
    }


}