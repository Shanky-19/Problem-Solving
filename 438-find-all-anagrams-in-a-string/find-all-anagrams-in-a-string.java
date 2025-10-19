class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int i = 0;
        int j = 0;
        int n = s.length();
        int m = p.length();
        int[] pattern = new int[26];
        for(char ch : p.toCharArray()) {
            pattern[ch-'a']++;
        }

        List<Integer> ans = new ArrayList<>();
        int[] window = new int[26];

        while (j < n) {
            int winLen = j - i + 1;
            if(winLen <= m) {
                char ch = s.charAt(j);
                window[ch-'a']++;
                j++;

                if(winLen == m) {
                    boolean eq = compare(pattern, window);
                    if(eq) {
                        ans.add(i);
                    }
                }
            } else {
                char ch = s.charAt(i);
                window[ch-'a']--;
                i++;
            }
        }   
        return ans;
    }

    private boolean compare (int[] pattern, int[] window) {
        for(int i=0;i<26;i++) {
            if(pattern[i] != window[i]){
                return false;
            }
        }
        return true;
    }
}
