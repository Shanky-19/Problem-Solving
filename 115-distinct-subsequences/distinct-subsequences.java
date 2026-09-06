class Solution {
    
    // Memoization
    /*
    public int helper(int i,int j,String s,String t,int[][] dp){
        if(j < 0){
            return 1;
        }else if(i < 0){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s.charAt(i) == t.charAt(j)){
            dp[i][j] = helper(i-1,j,s,t,dp) + helper(i-1,j-1,s,t,dp);
        }else{
            dp[i][j] = helper(i-1,j,s,t,dp);
        }
        return dp[i][j];
    }
    */
    
    public int numDistinct(String s, String t) {
        
        // Memoization
        /*
        int[][] dp = new int[s.length()][t.length()];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int ans = helper(s.length()-1,t.length()-1,s,t,dp);
        
        return ans;
        */
        
        // Tabulation
        /*
        int[][] dp = new int[t.length()+1][s.length()+1];
        for(int j=0;j<=s.length();j++){
            dp[0][j] = 1;
        }
        for(int i=1;i<=t.length();i++){
            for(int j=1;j<=s.length();j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
//                             not pick        pick
                    dp[i][j] = dp[i][j-1] + dp[i-1][j-1];
                }else{
                    dp[i][j] = dp[i][j-1];  
                }
            }
        }
        return dp[t.length()][s.length()];
        */
        
        // Space Optimization
        int[] prev = new int[s.length()+1];
        int[] curr = new int[s.length()+1];
        Arrays.fill(prev,1);
        for(int i=1;i<=t.length();i++){
            for(int j=1;j<=s.length();j++){
                if(t.charAt(i-1) == s.charAt(j-1)){
//                                not pick     pick
                    curr[j] = curr[j-1] + prev[j-1];
                }else{
                    curr[j] = curr[j-1];
                }
            }
            prev = curr;
            curr = new int[s.length()+1];
        }
        return prev[s.length()];
    }
}