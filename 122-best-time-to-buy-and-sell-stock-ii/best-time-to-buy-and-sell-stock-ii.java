class Solution {
    
    public int f(int i,int buy,int[][] dp,int[] prices){
        if(i == dp.length){
            return 0;
        }
        if(dp[i][buy] != -1){
            return dp[i][buy];
        }
        int profit = 0;
        if(buy == 1){// can buy
                                    // buy              not buy
            profit = Math.max(-prices[i] + f(i+1,0,dp,prices),f(i+1,1,dp,prices));
        }else{// can sell       
                                // sell                  not sell
            profit = Math.max(prices[i]+f(i+1,1,dp,prices),f(i+1,0,dp,prices));
        }
        
        dp[i][buy] = profit;
        return profit;
    }
    
    public int maxProfit(int[] prices) {
        
        // Memoization
        int[][] dp = new int[prices.length][2];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);        
        }
        int ans = f(0,1,dp,prices);
        return ans;
    }
}