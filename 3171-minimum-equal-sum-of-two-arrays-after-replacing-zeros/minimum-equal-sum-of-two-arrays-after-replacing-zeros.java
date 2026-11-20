class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0;
        int zeros1 = 0;
        for(int val : nums1) {
            sum1 += val;
            if(val == 0) {
                zeros1++;
            }
        }

        long sum2 = 0;
        int zeros2 = 0;
        for(int val : nums2) {
            sum2 += val;
            if(val == 0) {
                zeros2++;
            }
        }

        long minSumOfNum1 = sum1 + zeros1;
        long minSumOfNum2 = sum2 + zeros2;

        long minSumCanBeAcheived = Math.max(minSumOfNum1, minSumOfNum2);

        if(minSumOfNum1 == minSumOfNum2) {
            return minSumCanBeAcheived;
        } else if(minSumCanBeAcheived == minSumOfNum1) {
            if(zeros2 == 0){
                return -1;
            }
        } else if(minSumCanBeAcheived == minSumOfNum2) {
            if(zeros1 == 0){
                return -1;
            }
        }
        return minSumCanBeAcheived;
    }
}