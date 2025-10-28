class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] rightSum = new int[n];
        rightSum[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            rightSum[i] = rightSum[i+1] + nums[i];
        }
        int leftSum = 0;
        int ans = 0;
        for(int i=0;i<n;i++) {
            leftSum += nums[i];

            if(nums[i] == 0) {
                if(leftSum == rightSum[i]) {
                    ans += 2;
                } else if(Math.abs(leftSum - rightSum[i]) == 1) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}