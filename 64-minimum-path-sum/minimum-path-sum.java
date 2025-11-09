class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp) {
            Arrays.fill(arr, -1);
        }
        int ans = helper(0, 0, grid, n, m, dp);
        return ans;
    }

    private int helper(int r, int c, int[][] grid, int n, int m, int[][] dp) {
        if(r == n-1 && c == m-1) {
            return grid[r][c];
        }

        if(dp[r][c] != -1) {
            return dp[r][c];
        }

        int down = (int)1e9;
        if(r+1 < n) {
            down = grid[r][c] + helper(r+1,c, grid, n, m, dp);
        }
        int right = (int)1e9;
        if(c+1 < m) {
            right = grid[r][c] + helper(r, c+1, grid, n, m, dp);
        }

        return dp[r][c] = Math.min(right, down);
    }
}