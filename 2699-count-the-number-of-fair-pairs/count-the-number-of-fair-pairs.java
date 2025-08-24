class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        int n = nums.length;
        long ans = 0;
        Arrays.sort(nums);
        for(int i=0;i<n;i++) {
            int x = pairsSumLessThanLower(nums, i, lower);
            int y = pairsSumeLessThanEqualToUpper(nums, i, upper);
            ans += (y-x);
        }
        return ans;
    }

    private int pairsSumLessThanLower(int[] nums, int idx, int lower) {
        int n = nums.length;
        int low = idx+1;
        int high = n-1;
        int target = lower - nums[idx];
        int lessThanTargetIdx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] < target) {
                lessThanTargetIdx = mid;
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        if(lessThanTargetIdx == -1) {
            return 0;
        }
        int ans = lessThanTargetIdx - idx;
        return ans;
    }

    private int pairsSumeLessThanEqualToUpper(int[] nums, int idx, int upper) {
        int n = nums.length;
        int low = idx+1;
        int high = n-1;
        int target = upper - nums[idx];
        int lessThanEqualToTargetIdx = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;

            if(nums[mid] <= target) {
                lessThanEqualToTargetIdx = mid;
                low = mid + 1;
            } else {
                high = mid-1;
            }
        }
        if(lessThanEqualToTargetIdx == -1) {
            return 0;
        }
        int ans = lessThanEqualToTargetIdx - idx;
        return ans;
    }


}