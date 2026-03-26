class Solution {
    // Memoization
    /*
    public int f(int i,int buy,int trans,int[] prices,int[][][] dp){
        if(trans == 0){
            return 0;
        }
        if(i == prices.length){
            return 0;
        }
        if(dp[i][buy][trans] != -1){
            return dp[i][buy][trans];
        }
        int profit = 0;
        if(buy == 1){
            profit = Math.max(f(i+1,0,trans,prices,dp)-prices[i],f(i+1,1,trans,prices,dp));
        }else{
            profit = Math.max(f(i+1,1,trans-1,prices,dp)+prices[i],f(i+1,0,trans,prices,dp));
        }
        dp[i][buy][trans] = profit;
        return profit;
        
    }
    */
    public int maxProfit(int[] prices) {
        // Memoization
        /*
        int[][][] dp = new int[prices.length][2][3];
        for(int[][] arr1 : dp){
            for(int[] arr2 : arr1){
                Arrays.fill(arr2,-1);
            }
        }
        int ans = f(0,1,2,prices,dp);
        return ans;
        */
        
        // Tabulation
        /*
        int[][][] dp = new int[prices.length+1][2][3];
        // base case-1
        for(int i=0;i<=prices.length;i++){
            for(int buy=0;buy<=1;buy++){
                dp[i][buy][0] = 0;
            }
        }
        // base case-2
        for(int buy=0;buy<=1;buy++){
            for(int cap=0;cap<2;cap++){
                dp[prices.length][buy][cap] = 0; // here capacity means transaction
            }
        }
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy == 1){
                        dp[i][buy][cap] = Math.max(dp[i+1][0][cap]-prices[i],dp[i+1][1][cap]);
                    }else{
                        dp[i][buy][cap] = Math.max(dp[i+1][1][cap-1]+prices[i],dp[i+1][0][cap]);
                    }
                }
            }
        }
        return dp[0][1][2];
        */
        
        
        // Space optimization
        int[][] after = new int[2][3];
        int[][] curr = new int[2][3];

        // base case-1
        for(int i=0;i<=prices.length;i++){
            for(int buy=0;buy<=1;buy++){
                after[buy][0] = 0;
            }
        }
        // base case-2
        for(int buy=0;buy<=1;buy++){
            for(int cap=0;cap<2;cap++){
                after[buy][cap] = 0;
            }
        }
        
        for(int i=prices.length-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int cap=1;cap<=2;cap++){
                    if(buy == 1){
                        curr[buy][cap] = Math.max(after[0][cap]-prices[i],after[1][cap]);
                    }else{
                        curr[buy][cap] = Math.max(after[1][cap-1]+prices[i],after[0][cap]);
                    }
                }
            }
            after = curr;
        }
        return after[1][2];
    }
}