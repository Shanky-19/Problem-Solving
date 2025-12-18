class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int n = nums.length;
        int ans = 0;
        Map<Integer, Integer> fmap = new HashMap<>();
        while(j < n) {
            int val = nums[j];

            fmap.put(val, fmap.getOrDefault(val, 0) + 1);            
            if(fmap.get(val) > k) {
                while(i < j && nums[i] != val) {
                    fmap.put(nums[i], fmap.get(nums[i])-1);
                    if(fmap.get(nums[i]) == 0) {
                        fmap.remove(nums[i]);
                    }
                    i++;
                }
                if(fmap.size() > 0 && nums[i] == val) {
                    fmap.put(nums[i], fmap.get(nums[i])-1);
                    if(fmap.get(nums[i]) == 0) {
                        fmap.remove(nums[i]);
                    }
                    i++;
                }
            }
            ans = Math.max(ans, j-i+1);
            j++;
        }
        return ans;
    }
}