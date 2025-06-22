class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int partition = 0;
        int min = nums[0];
        for (int i = 1;  i < nums.length; i++) {
            if (nums[i] - min > k) {
                partition++;
                min = nums[i];
            }
        }
        return partition+1;
    }
}