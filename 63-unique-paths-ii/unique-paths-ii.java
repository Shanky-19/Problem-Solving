class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m-1] == 1){
            return 0;
        }

        int[][] dp = new int[n][m];
        dp[n-1][m-1] = 1;
        for(int i=n-2;i>=0;i--){
            if(obstacleGrid[i][m-1] == 1){
                dp[i][m-1] = 0;
            }else{
                dp[i][m-1] = dp[i+1][m-1];
            }
        }

        for(int j=m-2;j>=0;j--){
            if(obstacleGrid[n-1][j] == 1){
                dp[n-1][j] = 0;
            }else{
                dp[n-1][j] = dp[n-1][j+1];
            }
        }


        for(int i=n-2;i>=0;i--){
            for(int j=m-2;j>=0;j--){
                if(obstacleGrid[i][j] == 1){
                    dp[i][j] = 0;
                }else{
                    dp[i][j] = dp[i][j+1] + dp[i+1][j];
                }
            }
        }
        return dp[0][0];
        
    }
}