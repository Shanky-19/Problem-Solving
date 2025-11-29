class Solution {
    public int minOperations(int[] nums, int k) {
        int total = 0;
        for(int val : nums) {
            total += val;
        }
        return total%k;
    }
}