class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;
        int val = 0;
        for(int i=0;i<n-1;i++) {
            val ^= derived[i];
        }
        return (val == derived[n-1]);
    }
}