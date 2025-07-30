class Solution {

    private boolean isPrime (int n) {
        if(n <= 1) {
            return false;
        }
        if(n <= 3) {
            return true;
        }
        for(int i=2;i*i<=n;i++) {
            if(n%i == 0) {
                return false;
            }
        }
        return true;
    }
    
    public long splitArray(int[] nums) {
        long sumA = 0;
        long sumB = 0;
        for(int idx=0;idx<nums.length;idx++) {
            if(isPrime(idx)) {
                sumA += nums[idx];
            } else {
                sumB += nums[idx];
            }
        }

        return Math.abs(sumA- sumB);
    }
}