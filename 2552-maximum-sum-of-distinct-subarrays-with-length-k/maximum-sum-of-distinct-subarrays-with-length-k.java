class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0L;
        long ans = 0L;
        while (j < n) {
            fmap.put(nums[j], fmap.getOrDefault(nums[j], 0)+1);
            sum += nums[j];
            while (j-i+1 > k) {
                fmap.put(nums[i], fmap.get(nums[i])-1);
                if(fmap.get(nums[i]) == 0) {
                    fmap.remove(nums[i]);
                }
                sum -= nums[i];
                i++;
            }

            // now windowSize == k
            if(fmap.size() == k) {
                ans = Math.max(ans, sum);
            }
            j++;
        }
        return ans;
    }
}
