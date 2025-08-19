class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long ans = 0L;
        int n = nums.length;
        for(int i=0;i<n;i++) {
            if(nums[i] == 0) {
                long count = 0L;
                while (i < n && nums[i] == 0) {
                    count++;
                    i++;
                }
                ans += ((count) * (count+1))/2;
            }
        }
        return ans;
    }
}