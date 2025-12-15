class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // brute force
        int n = nums.length;
        int result = 0;
        for(int i=0;i<n;i++) {
            // subarrays which starts from nums[i]
            int sum = nums[i];
            int tempRes = 0;
            if(sum == goal) {
                tempRes++;
            }
            for(int j=i+1;j<n;j++) {
                sum += nums[j];
                if(sum == goal) {
                    tempRes++;
                }
            }
            result += tempRes;
        }
        return result;
    }
}