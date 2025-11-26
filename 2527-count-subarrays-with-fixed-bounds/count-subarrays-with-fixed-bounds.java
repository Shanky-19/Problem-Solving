class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
       // brute force
       /*
        int n = nums.length;
        int i = 0;
        int ans = 0;
        while (i < n) {
            int j = i;
            int currMin = nums[i];
            int currMax = nums[i];
            while (j < n) {
                int val = nums[j];
                currMin = Math.min(currMin, nums[j]);
                currMax = Math.max(currMax, nums[j]);

                if(currMin == minK && currMax == maxK) {
                    ans++;
                }
                j++;
            }
            i++;
        }
        return ans;
        */

        int n = nums.length;
        int minPos = -1;
        int maxPos = -1;
        int culpritIdx = -1;
        long ans = 0L;
        for (int i=0;i<n;i++) {
            int val = nums[i];

            if(val < minK || val > maxK) {
                culpritIdx = i;
            }

            if(val == minK) {
                minPos = i;
            }

            if(val == maxK) {
                maxPos = i;
            }

            long count = Math.min(minPos, maxPos) - culpritIdx;

            if(count > 0) {
                ans += count;
            }
        } 
        return ans;
    }
}