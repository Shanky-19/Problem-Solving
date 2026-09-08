class Solution {
    int mod = 1000000007;
    public int distinctSubseqII(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        //        char      idx
        HashMap<Character,Integer> lastOccurence = new HashMap<>();
        for(int i=1;i<dp.length;i++){
            char ch = s.charAt(i-1);
            dp[i] = (2*dp[i-1])%mod;
            if(lastOccurence.containsKey(ch)){
                dp[i] = (dp[i] - dp[lastOccurence.get(ch)-1])%mod;
                if(dp[i] < 0){
                    dp[i] += mod;
                }
            }
            lastOccurence.put(ch,i);
        }
        if(dp[s.length()]-1 < 0){
            return dp[s.length()]-1 + mod;
        }
        return (dp[s.length()] - 1); // -1 becoz of non empty
    }
}