class Solution {
    public boolean checkStrings(String s1, String s2) {
        int n = s1.length();
        int[] fmap = new int[26];
        // even indices
        for(int i=0;i<n;i+=2) {
            int idx1 = s1.charAt(i)-'a';
            fmap[idx1]++;
            int idx2 = s2.charAt(i)-'a';
            fmap[idx2]--;
        }

        // check 
        for(int i=0;i<26;i++) {
            if(fmap[i] != 0) {
                return false;
            }
        }

        fmap = new int[26];
        // odd indices
        for(int i=1;i<n;i+=2) {
            int idx1 = s1.charAt(i)-'a';
            fmap[idx1]++;
            int idx2 = s2.charAt(i)-'a';
            fmap[idx2]--;
        }

        // check 
        for(int i=0;i<26;i++) {
            if(fmap[i] != 0) {
                return false;
            }
        }
        return true;
    }
}