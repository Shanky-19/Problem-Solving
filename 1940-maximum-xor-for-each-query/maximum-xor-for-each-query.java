class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int maxK = (1 << maximumBit) - 1;
        int[] ans = new int[n];

        int xor = 0;
        for(int num : nums) {
            xor ^= num;
        }

        for(int i = 0; i < n; i++) {
            ans[i] = maxK ^ xor;
            xor ^= nums[n - 1 - i];
        }

        return ans;
    }
}