class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        Map<Character, Integer> fmap = new HashMap<>();
        int ans = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if(fmap.containsKey(ch)) {
                while (i<=j && s.charAt(i) != ch) {
                    fmap.remove(s.charAt(i));
                    i++;
                }
                fmap.remove(s.charAt(i));
                i++;
                ans = Math.max(ans, j-i+1);
            } else {
                fmap.put(ch, 1);
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }
        return ans;
    }
}