class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int maxSum = 0;
        int tempSum = 0;
        Map<Integer, Integer> fmap = new HashMap<>();
        while(j < n) {
            int val = nums[j];
            tempSum += val;
            if(fmap.containsKey(val)) {
                while(i<j && fmap.containsKey(val)) {
                    fmap.remove(nums[i]);
                    tempSum -= nums[i];
                    i++;
                }
            }
            fmap.put(val, 1);
            j++;
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }
}