class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        for(int val : nums) {
            maxOr |= val;
        }
        
        // now find subsets which have maxOr
        int count = subsetCount(nums, 0, 0, maxOr);
        return count;
    }

    private int subsetCount(int[] nums, int idx, int currentOr, int maxOr) {
        if(idx == nums.length) {
            if(maxOr == currentOr) {
                return 1;
            } else {
                return 0;
            }
        }

        // pick
        int pick = subsetCount(nums, idx+1, currentOr | nums[idx], maxOr);

        // not pick
        int notPick = subsetCount(nums, idx+1, currentOr, maxOr);

        return pick + notPick;
    }
}