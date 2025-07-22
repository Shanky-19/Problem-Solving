class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int maxSum = 0;
        int tempSum = 0;
        Set<Integer> fmap = new HashSet<>();
        while(j < n) {
            int val = nums[j];
            tempSum += val;
            if(fmap.contains(val)) {
                while(i<j && fmap.contains(val)) {
                    fmap.remove(nums[i]);
                    tempSum -= nums[i];
                    i++;
                }
            }
            fmap.add(val);
            j++;
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}