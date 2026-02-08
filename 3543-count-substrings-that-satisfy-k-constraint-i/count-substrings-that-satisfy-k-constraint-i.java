class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int freqZero = 0;
        int freqOne = 0;
        int ans = 0;
        while (j < n) {
            if(s.charAt(j) == '0') {
                freqZero++;
            } else {
                freqOne++;
            }

            while(freqZero > k && freqOne > k) {
                if(s.charAt(i) == '0') {
                    freqZero--;
                } else {
                    freqOne--;
                }
                i++;
            }
            // System.out.println("j - i + 1: " + (j - i + 1));
            ans += (j-i+1);
            j++;
        }
        return ans;
    }
}