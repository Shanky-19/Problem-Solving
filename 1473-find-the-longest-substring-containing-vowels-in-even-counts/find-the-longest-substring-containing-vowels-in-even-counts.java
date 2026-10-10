class Solution {
    public int findTheLongestSubstring(String s) {
        int j = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int mask = 0;
        map.put(mask, -1);
        int ans = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            int val = 0;
            if(ch == 'a') {
                val ^= (1<<0);
            } else if(ch == 'e') {
                val ^= (1<<1);
            } else if(ch == 'i') {
                val ^= (1<<2);
            } else if(ch == 'o') {
                val ^= (1<<3);
            } else if(ch == 'u') {
                val ^= (1<<4);
            }

            mask ^= val;
            if(!map.containsKey(mask)) {
                map.put(mask, j);
            }

            ans = Math.max(ans, j - map.get(mask));
            j++;
        }
        return ans;
    }
}