class Solution {
    int m,n,k;
    final int mod= 1_000_000_007;
    /*NOTE: (a+b)%k == ((a%k)+(b%k))%k; */
    Integer dp[][][];

    public boolean isValid(int i, int j){
        return i>=0 && i<m && j>=0 && j<n;
    }

    public int numberOfPaths(int[][] grid, int k) {
        m=grid.length;
        n=grid[0].length;
        this.k=k;
        dp= new Integer[m][n][k];
        return solve(0,0,0,grid);   
    }

    public int solve(int i, int j, int sum, int grid[][]){
        if(!isValid(i,j)) return 0;
        
        sum=(sum+grid[i][j])%k;

        if(i==m-1 && j==n-1) {
            return sum%k==0?1:0;
        }
        if(dp[i][j][sum]!=null) return dp[i][j][sum]%mod;
       
        int down=solve(i+1,j,sum,grid);
        int right=solve(i,j+1,sum,grid);

        return dp[i][j][sum]=(down+right)%mod;
    }

}