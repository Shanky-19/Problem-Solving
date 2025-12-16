class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        int i = 0;
        int j = 0;
        int sum = 0;
        int n = nums.length;
        int prefixZeros = 0;

        while (j < n) {
            sum += nums[j];
            while (i < j && (nums[i] == 0 || sum > goal)) {
                if (nums[i] == 1) {
                    prefixZeros = 0;
                } else {
                    prefixZeros += 1;
                }

                sum -= nums[i];
                i++;
            }

            if(sum == goal) {
                ans += 1 + prefixZeros;
            } 
            j++;
        }
        return ans;
    }
}