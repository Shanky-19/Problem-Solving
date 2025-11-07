class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0;
        while (j < n) {
            char ch = s.charAt(j);
            if(set.contains(ch)) {
                while (i<=j && s.charAt(i) != ch) {
                    set.remove(s.charAt(i));
                    i++;
                }
                set.remove(s.charAt(i));
                i++;
                ans = Math.max(ans, j-i+1);
            } else {
                set.add(ch);
                ans = Math.max(ans, j-i+1);
                j++;
            }
        }
        return ans;
    }
}