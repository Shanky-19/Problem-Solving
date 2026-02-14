class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> fmap = new HashMap<>();
        int n = nums.length;
        int i = 0;
        int j = 0;
        long sum = 0L;
        long ans = 0L;
        while (j < n) {
            int val = nums[j];
            fmap.put(val, fmap.getOrDefault(val, 0)+1);
            sum += val;
            int windowSize = j-i+1;
            if(windowSize < k) {
                j++;
            } else {
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
        }
        return ans;
    }
}
