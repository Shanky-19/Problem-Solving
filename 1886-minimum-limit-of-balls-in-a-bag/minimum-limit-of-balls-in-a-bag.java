class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int n = nums.length;
        int low = 1;
        int high = 0;
        for(int val : nums) {
            high = Math.max(high, val);
        }

        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low)/2;

            long operations = countOperations(nums, mid);
            if(operations <= maxOperations) {
                ans = mid;
                high = mid-1;
            } else{
                low = mid+1;
            }
        }
        return ans;
    }

    private long countOperations(int[] nums,int maxPenalty) {
        long operations = 0;
        for(int val : nums) {
            operations += (long)Math.ceil((val*1.0)/maxPenalty) - 1;
        }
        return operations;
    }
}