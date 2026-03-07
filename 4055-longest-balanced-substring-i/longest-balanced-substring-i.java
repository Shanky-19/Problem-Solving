
class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int[] cnt = new int[26];
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            Arrays.fill(cnt, 0);
            int max = 0;
            int v = 0;
            for (int j = i; j < n; ++j) {
                int c = s.charAt(j) - 'a';
                cnt[c]++;
                if (cnt[c] == 1) {
                    v++;
                }
                max = Math.max(max, cnt[c]);
                if (max * v == j - i + 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
        }
        return ans;
    }
}