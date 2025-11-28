class Solution {
    int M = 1000000007;
    public int numberOfPaths(int[][] grid, int k) {
        /*
        int i = 0;
        int j = 0;
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];
        for(int[][] arr : dp) {
            for(int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        int sum = 0;
        return solve(i, j, grid, m, n, k, sum, dp);
        */

        // Tabulation
        int m = grid.length;
        int n = grid[0].length;

        int[][][] t = new int[m+1][n+1][k+1];

        // Base case same as recursion
        for (int remain = 0; remain < k; remain++) {
            t[m-1][n-1][remain] = 
                ((remain + grid[m-1][n-1]) % k == 0) ? 1 : 0;
        }

        // Fill bottom-up
        for (int row = m - 1; row >= 0; row--) {
            for (int col = n - 1; col >= 0; col--) {

                for (int remain = 0; remain < k; remain++) {

                    if (row == m - 1 && col == n - 1) {
                        continue;
                    }

                    int newRemain = (remain + grid[row][col]) % k;

                    long down  = t[row + 1][col][newRemain];
                    long right = t[row][col + 1][newRemain];

                    t[row][col][remain] = (int)((down + right) % M);
                }
            }
        }

        return t[0][0][0];
    }

    private int solve(int i,int j, int[][] grid, int m, 
                        int n, int k, int sum, int[][][] dp) {
        
        if(i>=m || j >= n) {
            return 0;
        }

        if(i == m-1 && j == n-1) {
            sum = (sum + grid[i][j])%k;
            return dp[i][j][sum] = (sum == 0) ? 1 : 0;
        }

        if(dp[i][j][sum] != -1) {
            return dp[i][j][sum];
        }

        int count1 = 0;
        if(i + 1 < m) {
            count1 = solve(i+1, j, grid, m, n, k, (sum + grid[i][j])%k, dp);
        }

        int count2 = 0;
        if(j + 1 < n) {
            count2 = solve(i, j+1, grid, m, n, k, (sum + grid[i][j])%k, dp);
        }

        return dp[i][j][sum] = (count1 + count2)%M;
        

    }
}