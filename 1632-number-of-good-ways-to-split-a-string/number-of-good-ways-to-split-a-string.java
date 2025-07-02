class Solution {
    public int numSplits(String s) {
        Map<Character, Integer> leftMap = new HashMap<>();
        Map<Character, Integer> rightMap = new HashMap<>();
        int ans = 0;
        for(char ch : s.toCharArray()) {
            rightMap.put(ch, rightMap.getOrDefault(ch, 0)+1);
        }

        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);

            leftMap.put(ch, leftMap.getOrDefault(ch, 0) + 1);
            rightMap.put(ch, rightMap.get(ch) - 1);
            if(rightMap.get(ch) == 0) {
                rightMap.remove(ch);
            }

            if(leftMap.size() == rightMap.size()) {
                ans++;
            }
        }

        return ans;
    }
}