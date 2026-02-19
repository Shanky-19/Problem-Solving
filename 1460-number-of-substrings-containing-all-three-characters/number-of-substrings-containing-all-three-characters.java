class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int i = 0;
        int j = 0;
        int[] fmap = new int[3];
        int ans = 0;
        while (j < n) {
            char ch = s.charAt(j);
            fmap[ch-'a']++;

            
            while (i< n && containsAll(fmap)) {
                ans += (n-j);
                char front = s.charAt(i);
                fmap[front-'a']--;
                i++;
            }
            
            j++;
        }
        return ans;
    }

    private boolean containsAll(int[] fmap) {
        return ((fmap[0] > 0 )&& (fmap[1] > 0) && (fmap[2] > 0));
    }
}