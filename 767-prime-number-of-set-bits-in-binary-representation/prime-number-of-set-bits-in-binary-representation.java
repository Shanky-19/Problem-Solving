class Solution {
    public int countPrimeSetBits(int left, int right) {
        int ans = 0;
        for(int i=left;i<=right;i++) {
            int setBits = 0;
            int val = i;
            while (val > 0) {
                int bit = (val & 1);
                if(bit == 1) {
                    setBits++;
                }
                val = val>>1;
            }
            if(isPrime(setBits)) {
                ans++;
            }
        }
        return ans;
    }

    private boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        for(int i=2;i*i<=n;i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
}