class Solution {
    public int maxFreqSum(String s) {
        int[] arr = new int[26];
        for (char ch : s.toCharArray()) {
            arr[ch-'a']++;
        }

        int vowel = 0;
        int consonent = 0;
        for(int i=0;i<26;i++) {
            char ch = (char)(i + 'a');
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o'|| ch == 'u') {
                vowel = Math.max(arr[i], vowel);
            } else {
                consonent = Math.max(arr[i], consonent);
            }
        }
        return vowel + consonent;
    }
}