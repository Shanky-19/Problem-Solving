class Solution {
    public int longestSubsequence(String s, int k) {
        int n = s.length();

        //DP solution
        /* 
        int[][] dp = new int[n+1][k+1];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i], -1);
        }
        return solve(s, k, s.length()-1, dp);
        */

        // Greedy Solution
        int length = 0;
        for(int i=n-1;i>=0;i--) {
            int bit = s.charAt(i)-'0';
            int val = bit * (int) Math.pow(2, n-i-1);

            if(val <= k) {
                // we can take this char
                k -= val;
                length += 1;
            }
        }
        return length;

    }

    private int solve(String s, int k, int idx, int[][] dp) {
        if(idx < 0) {
            return 0;
        }

        if(dp[idx][k] != -1) {
            return dp[idx][k];
        }

        // pick
        // if we pick this bit -> Pow(2, n-i-1)
        int bit = (s.charAt(idx)-'0');
        int val = bit * (int) Math.pow(2, s.length()-idx-1); 
        int length1 = 0;
        if(val <= k) {
            length1 = 1 + solve(s, k-val, idx-1, dp);
        }
        
        // not pick
        int length2 = solve(s, k, idx-1, dp);

        return dp[idx][k] = Math.max(length1, length2);
    }





}