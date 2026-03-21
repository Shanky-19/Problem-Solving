class Solution {
    public int countSubstrings(String s) {
        // Gap Method

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        // dp[i][j] -> i se j tak ki substring ka answer
        int ans = 0;
        for(int gap=0;gap<n;gap++) {
            for(int i=0, j=gap; j<n; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = true;
                } else if (gap == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = false;
                }

                if(dp[i][j]) {
                    ans++;
                }
            }
        }
        return ans;
    }
}