class Solution {

    private int count (int num) {
        int bits = 0;
        while(num > 0) {
            bits++;
            num = num & (num-1);
        }
        return bits;
    }

    public int[] countBits(int n) {
        int[] ans = new int[n+1];
        for(int i=0;i<=n;i++) {
            ans[i] = count(i);
        }
        return ans;
    }
}