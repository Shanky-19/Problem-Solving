class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n = nums.length;
        int si = 1;
        int sd = 1;
        int maxSI = 1;
        int maxSD = 1;

        for(int i=1;i<n;i++) {
            if(nums[i] > nums[i-1]) {
                si++;
                sd=1;
            } else if(nums[i] < nums[i-1]) {
                sd++;
                si=1;
            } else {
                si = 1;
                sd = 1;
            }
            maxSI = Math.max(maxSI, si);
            maxSD = Math.max(maxSD, sd);
        }
        return Math.max(maxSD, maxSI);
    }
}