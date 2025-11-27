class Solution {

    public int maxVowels(String s, int k) {

        Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');
        int i = 0;
        int j = 0;
        int n = s.length();
        int currCount = 0;
        int ans = 0;
        while (j < n) {
            int winSize = j - i + 1;
            char ch = s.charAt(j);
            if(winSize <= k) {
                if(vowels.contains(ch)) {
                    currCount++;
                } 
                ans = Math.max(ans, currCount);

            } else {
                if(vowels.contains(ch)) {
                    currCount++;
                } 
                char c = s.charAt(i);
                if(vowels.contains(c)) {
                    currCount--;
                }
                i++;
                ans = Math.max(ans, currCount);

            }
            j++;
        }
        return ans;
    }

}
        
    