class Solution {
    public int numberOfSpecialChars(String word) {
        int[] lower = new int[26];
        int[] upper = new int[26];

        for(char ch : word.toCharArray()) {
            int idx;
            if(ch >= 97 && ch <=122) {
                idx = ch - 'a';
                lower[idx] = 1;
            } else if (ch >= 65 && ch <= 90) {
                idx = ch - 'A';
                upper[idx] = 1;
            }
        }
        int ans = 0;
        for(int i=0;i<26;i++) {
            if(lower[i] == 1 && upper[i] == 1) {
                ans++;
            }
        }
        return ans;
    }
}