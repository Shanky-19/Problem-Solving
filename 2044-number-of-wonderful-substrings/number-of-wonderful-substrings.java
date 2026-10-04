class Solution {
    public long wonderfulSubstrings(String word) {
        int cumXor = 0;
        long ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(cumXor, 1);
        Set<Character> uniqueChars = new HashSet<>();
        for(char ch : word.toCharArray()) {
            uniqueChars.add(ch);
        }
        
        for(char ch : word.toCharArray()) {
            int binary = (1 << (ch - 'a'));
            cumXor ^= binary;
            if(map.containsKey(cumXor)) {
                ans += map.get(cumXor);
            }
            map.put(cumXor, map.getOrDefault(cumXor, 0) + 1);

            for(char c : uniqueChars) {
                int tempXor = cumXor ^ (1 << (c - 'a'));
                if(map.containsKey(tempXor)) {
                    ans+=map.get(tempXor);
                }
            }
        }
        return ans;
    }
}