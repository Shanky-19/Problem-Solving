class Solution {
    public int countCompleteSubstrings(String word, int k) {
        // Sliding Window
        int n = word.length();

        // Partitioning
        int last = 0;
        int result = 0;
        for(int i=1;i<=n;i++) { // "aa | ddff | kk |"
            if(i==n || Math.abs(word.charAt(i) - word.charAt(i-1)) > 2) {
                result += solve(last, i-1, word, k);
                last = i;
            }
        }
        return result;
    }

    private int solve (int start, int end, String word, int k) {
        int result = 0;

        for (int uniqueChar = 1;(uniqueChar <= 26)
            && (uniqueChar*k <= (end-start+1));uniqueChar++) {
            
            int[] fmap = new int[26];
            int goodBoy = 0;

            // now start sliding window
            int i = start;
            int j = start;
            int windowLength = uniqueChar * k;
            while (j <= end) {
                char ch = word.charAt(j);
                fmap[ch-'a']++;
                if(fmap[ch-'a'] == k) {
                    goodBoy++;
                } else if(fmap[ch-'a'] == k+1) {
                    goodBoy--;
                }
                int windowSize = j-i+1;
                if(windowSize > windowLength) { 
                    if(fmap[word.charAt(i)-'a'] == k) {
                        goodBoy--;
                    } else if (fmap[word.charAt(i)-'a'] == k+1) {
                        goodBoy++;
                    }
                    fmap[word.charAt(i)-'a']--;
                    i++;
                }

                if(goodBoy == uniqueChar) {
                    result += 1;
                }
                j++;
            }
        }
        return result;
    }
}