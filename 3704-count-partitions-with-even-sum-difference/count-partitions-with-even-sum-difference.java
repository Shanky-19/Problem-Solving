class Solution {
    public int countPartitions(int[] nums) {
        int totalSum = 0;
        for(int val : nums) {
            totalSum += val;
        }

        int leftSum = 0;
        int rightSum = totalSum;
        int ans = 0;
        for(int i=0;i<nums.length-1;i++) {
            leftSum += nums[i];
            rightSum -= nums[i];
            if(Math.abs(rightSum - leftSum)%2 == 0) {
                ans++;
            }
        }
        return ans;
    }
}