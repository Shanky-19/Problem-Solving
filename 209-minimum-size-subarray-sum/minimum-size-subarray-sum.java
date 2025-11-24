class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        
        int j = 0;
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        while (j < n) {
            sum += nums[j];
            if(sum < target) {
                j++;
            } else {    
                while (i<=j && sum >= target) {
                    ans = Math.min(ans, j-i+1);
                    sum -= nums[i];
                    i++;
                }
                j++;
            }
        }
        return (ans == Integer.MAX_VALUE) ? 0 : ans;
    }
}