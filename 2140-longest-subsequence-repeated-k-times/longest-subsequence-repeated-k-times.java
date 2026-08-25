class Solution {
    String result = "";

    // Check if seq * k is a subsequence of s
    private boolean isSubsequence(String s, String sub, int k) {
        int i = 0;
        int j = 0;
        int len = sub.length();
        int n = s.length();

        while (i < n && j < k * len) {
            if (s.charAt(i) == sub.charAt(j % len)) {
                j++;
            }
            i++;
        }

        return (j == k * len);
    }

    private void solve(String s, StringBuilder curr, boolean[] canUse,
                        int[] maxFreqInOneSubsequence,int k, int maxLen) {

        if (curr.length() > maxLen) {
            return;
        }

        String currStr = curr.toString();
        if ((curr.length() > result.length() || 
             (curr.length() == result.length() && currStr.compareTo(result) > 0)) 
            &&
            isSubsequence(s, currStr, k)) {
                
            result = currStr;
        }

        for (int i = 25; i >= 0; i--) { // from 'z' to 'a' for lexicographically larger result
            if (!canUse[i] || maxFreqInOneSubsequence[i] == 0) {
                continue;
            }

            curr.append((char) (i + 'a'));
            maxFreqInOneSubsequence[i]--;

            solve(s, curr, canUse, maxFreqInOneSubsequence, k, maxLen);

            curr.deleteCharAt(curr.length() - 1);
            maxFreqInOneSubsequence[i]++;
        }
    }

    public String longestSubsequenceRepeatedK(String s, int k) {
        int n = s.length();
        int[] freqMap = new int[26];
        for(char ch : s.toCharArray()) {
            freqMap[ch - 'a']++;
        }

        boolean[] canUse = new boolean[26];
        int[] maxFreqInOneSubsequence = new int[26];
        for(int i=0;i<26;i++) {
            if(freqMap[i] >= k) {
                canUse[i] = true;
                maxFreqInOneSubsequence[i] = freqMap[i]/k; // at-most
            }
        }

        int maxLen = n/k;

        StringBuilder curr = new StringBuilder();
        solve(s, curr, canUse, maxFreqInOneSubsequence, k, maxLen);
        return result;
    }


}