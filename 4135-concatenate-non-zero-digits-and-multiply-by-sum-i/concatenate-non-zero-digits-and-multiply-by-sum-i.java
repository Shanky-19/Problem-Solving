class Solution {

    private int reverse(int val) {
        int ans = 0;
        while(val > 0) {
            ans = ans * 10 + (val%10);
            val = val/10;
        }
        return ans;
    }

    public long sumAndMultiply(int n) {
        int nonZeroRev = 0;
        int sum = 0;
        while(n > 0) {
            int rem = n%10;
            if(rem != 0) {
                nonZeroRev = nonZeroRev * 10 + rem;
                sum += rem;
            }
            n = n/10;
        }
        int nonZero = reverse(nonZeroRev);
        long ans = 1L * nonZero * sum;
        return ans;
    }
}