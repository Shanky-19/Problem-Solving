class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> fmap = new HashMap<>();
        while(j < n) {
            fmap.put(nums[j], fmap.getOrDefault(nums[j],0)+1);
            while (i<j && fmap.get(nums[j]) > k) {
                fmap.put(nums[i], fmap.get(nums[i])-1);
                i++;
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}