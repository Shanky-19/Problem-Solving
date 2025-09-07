class Solution {
    public String longestPalindrome(String str) {
        int n = str.length();
        
        boolean[][] dp = new boolean[n][n];
        // gap Method -> length = gap+1;
        
        int longest = 1;
        int startingCharacterIdx = 0;
        
        for(int gap=0;gap<n;gap++){
            for(int i=0,j=gap;j<n;j++,i++){
                if(gap == 0){
                    dp[i][j] = true;
                }else if(gap == 1){
                    dp[i][j] = (str.charAt(i) == str.charAt(j));
                }else{
                    dp[i][j] = ((str.charAt(i) == str.charAt(j)) && (dp[i+1][j-1]));
                }
                
                if(dp[i][j] && (gap+1 > longest)){
                    longest = gap+1;
                    startingCharacterIdx = i;
                }
            } 
        }
        
        return str.substring(startingCharacterIdx,startingCharacterIdx + longest);
        
    }
}