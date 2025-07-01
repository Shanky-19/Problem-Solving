class Solution {
    public int possibleStringCount(String word) {
        // alice type everything correct -> 0 clumsyness
        int ans = 1;
        char currentChar = word.charAt(0);
        int currentFreq = 1;
        for(int i=1;i<word.length();i++) {
            char ch = word.charAt(i);
            if(currentChar == ch) {
                currentFreq++;
            }else {
                ans += (currentFreq-1);
                currentChar = ch;
                currentFreq = 1;
            }
        }
        if(currentFreq > 0) {
            ans += (currentFreq-1);
        }
        return ans;

    }
}