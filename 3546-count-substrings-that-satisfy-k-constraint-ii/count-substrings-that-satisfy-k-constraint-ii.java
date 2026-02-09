//T.C : O(n + Q), where n = s.length and Q = number of queries
//S.C : O(n)
class Solution {
    public long[] countKConstraintSubstrings(String s, int k, int[][] queries) {
        int n = s.length();
        
        int[] leftMost = new int[n];
        int[] rightMost = new int[n];
        
        // Left-most valid index for each position
        int i = 0;
        int j = 0;
        Map<Character, Integer> mp = new HashMap<>();
        
        while (j < n) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            while (mp.getOrDefault('0', 0) > k && mp.getOrDefault('1', 0) > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i++;
            }
            leftMost[j] = i;
            j++;
        }
        
        // Right-most valid index for each position
        mp.clear();
        i = n - 1;
        j = n - 1;
        while (j >= 0) {
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            while (mp.getOrDefault('0', 0) > k && mp.getOrDefault('1', 0) > k) {
                mp.put(s.charAt(i), mp.get(s.charAt(i)) - 1);
                i--;
            }
            rightMost[j] = i;
            j--;
        }
        
        // Number of valid substrings ending at each position
        int[] tempValidSubstr = new int[n];
        for (j = 0; j < n; j++) {
            tempValidSubstr[j] = j - leftMost[j] + 1;
        }
        
        // Cumulative sum of valid substrings
        long[] cumSum = new long[n];
        cumSum[0] = tempValidSubstr[0];
        for (i = 1; i < n; i++) {
            cumSum[i] = cumSum[i - 1] + tempValidSubstr[i];
        }
        
        long[] result = new long[queries.length];
        for (i = 0; i < queries.length; i++) {
            int low = queries[i][0];
            int high = queries[i][1];
            
            int validRightIdx = Math.min(high, rightMost[low]);
            
            long length = validRightIdx - low + 1;
            
            long tempResult = length * (length + 1) / 2;
            
            if (validRightIdx < high) {
                tempResult += cumSum[high] - cumSum[validRightIdx];
            }
            
            result[i] = tempResult;
        }
        
        return result;
    }
}