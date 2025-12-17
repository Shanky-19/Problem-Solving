class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // khandani sliding window
        int i = 0;
        int j = 0;
        int n = nums.length;
        int product = 1;
        int ans = 0;
        while (j < n) {
            product *= nums[j];
            while(i < j && product >= k) {
                product /= nums[i];
                i++;
            }

            if (product < k) {
                ans += (j-i+1);
            }
            j++;
        }
        return ans;
    }
}