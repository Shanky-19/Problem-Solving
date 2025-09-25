class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        
        // space optimization 2D dp to 1D dp
        
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=triangle.get(n-1).get(i);
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[j]=Math.min(dp[j],dp[j+1])+triangle.get(i).get(j);
            }
        }
        return dp[0];
        
        
        /*
        int[][] dp = new int[n][n];
        for(int j=0;j<n;j++){
            dp[n-1][j] = triangle.get(n-1).get(j);
        }
        
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j],dp[i+1][j+1]);// down and diagonal
            }
        }
        
        return dp[0][0];
        */
    }
}