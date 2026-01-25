class Solution {
    public int minimumDifference(int[] nums, int k) {

        if(k == 1 || nums.length == 1) {
            return 0;
        }

        Arrays.sort(nums);
        int n = nums.length;
        int minDiff = Integer.MAX_VALUE;
        int i = 0;
        int j = k-1;

        while (j < n) {
            int maxElement = nums[j];
            int minElement = nums[i];

            minDiff = Math.min(maxElement - minElement, minDiff);
            j++;
            i++;
        }
        
        return minDiff;
    }
}