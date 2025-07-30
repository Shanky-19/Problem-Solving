class Solution {
    public int longestSubarray(int[] nums) {
        
        int maxAnd = nums[0];
        for(int val : nums) {
            maxAnd = Math.max(maxAnd, val);
        }
        int i = 0;
        int maxSize = 0;
        while(i < nums.length) {
            int val = nums[i];
            int size = 0;
            if(val == maxAnd) {
                while(i < nums.length && nums[i] == maxAnd) {
                    i++;
                    size++;
                }
            } else {
                i++;
            }
            maxSize= Math.max(maxSize, size);
        }
        return maxSize;
    }

}