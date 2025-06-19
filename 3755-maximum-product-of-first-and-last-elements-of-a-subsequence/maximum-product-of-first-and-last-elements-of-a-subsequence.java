class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long maxi = Long.MIN_VALUE;
        if(m == 1) {
            for(int i=0;i<n;i++) {
                maxi = Math.max(maxi, 1L*nums[i]*nums[i]);
            }
            return maxi;
        }

        int[] maxFromRight = new int[n];
        int[] minFromRight = new int[n];
        maxFromRight[n-1] = nums[n-1];
        minFromRight[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            maxFromRight[i] = Math.max(maxFromRight[i+1], nums[i]);
            minFromRight[i] = Math.min(minFromRight[i+1], nums[i]);
        }

        for(int i=0;i<n;i++) {
            // here i is our first idx of subsequence
            int lastIdxToMakeSubseqOfSizeM = i+m-1; 
            if(nums[i] > 0 && lastIdxToMakeSubseqOfSizeM < n) {
                maxi = Math.max(maxi,1L * nums[i] * maxFromRight[lastIdxToMakeSubseqOfSizeM]);
            } else {
                if(lastIdxToMakeSubseqOfSizeM < n) {
                    maxi = Math.max(maxi, 1L* nums[i] * minFromRight[lastIdxToMakeSubseqOfSizeM]);
                }
            }
        }
        return maxi;
    }
}