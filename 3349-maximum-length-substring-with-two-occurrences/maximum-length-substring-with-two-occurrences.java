class Solution {
    public int maximumLengthSubstring(String s) {
        int i = 0;
        int j = 0;
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();
        int len = 0;
        int ans = 0;
        while(j < n) {
            char ch = s.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
            len++;

            if(map.get(ch) > 2) {
                while(i< n && s.charAt(i) != ch) {
                    map.put(s.charAt(i), map.get(s.charAt(i))-1);
                    len--;
                    i++;
                }
                map.put(s.charAt(i), map.get(s.charAt(i))-1);
                i++;
                len--;
            }
            ans = Math.max(len, ans);
            j++;
        }
        return ans;
    }
}