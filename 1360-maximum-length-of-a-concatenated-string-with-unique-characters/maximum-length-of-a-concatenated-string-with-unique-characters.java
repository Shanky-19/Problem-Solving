class Solution {

    private int solve (int idx, int temp, 
                        List<Integer> uniqueCharStrings) {
        if(idx == uniqueCharStrings.size()) {
            return Integer.bitCount(temp);
        }

        // pick 
        int ans1 = 0;
        if((temp & uniqueCharStrings.get(idx)) == 0) {
            ans1 = solve(idx+1, temp | uniqueCharStrings.get(idx), 
                        uniqueCharStrings);
        }
        // not pick
        int ans2 = solve(idx+1, temp, uniqueCharStrings);

        return Math.max(ans1, ans2);
    }

    public int maxLength(List<String> arr) {
        int n = arr.size();
        List<Integer> uniqueCharStrings = new ArrayList<>();
        for(int i=0;i<n;i++) {
            String str = arr.get(i);

            Set<Character> set = new HashSet<>();
            for(char ch : str.toCharArray()) {
                set.add(ch);
            }
            if(set.size() != str.length()) {
                continue;
            }

            int val = 0;
            for(char ch : str.toCharArray()) {
                int bit = ch - 'a';
                int bitmask = (1<<bit);
                val = val | bitmask;
            }
            uniqueCharStrings.add(val);
        }

        int temp = 0;
        int idx = 0;
        int ans = solve(idx, temp, uniqueCharStrings);
        return ans;
    }
}