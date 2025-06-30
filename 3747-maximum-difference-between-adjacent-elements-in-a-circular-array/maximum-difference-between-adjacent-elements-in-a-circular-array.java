class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int diff = Integer.MIN_VALUE;
        for(int i=0;i<nums.length-1;i++) {
            diff = Math.max(diff, Math.abs(nums[i]-nums[i+1]));
        }
        diff = Math.max(diff, Math.abs(nums[0]-nums[nums.length-1]));
        return diff;
    }
}