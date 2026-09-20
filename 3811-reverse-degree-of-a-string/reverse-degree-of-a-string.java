class Solution {
    public int reverseDegree(String s) {
        int ans = 0;
        for(int i=1;i<=s.length();i++) {
            char ch = s.charAt(i-1);
            int idxReverseAlpha = 26 - (ch - 'a');
            ans += idxReverseAlpha * i;
        }
        return ans;
    }
}