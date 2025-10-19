class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k == 0) {
            return false;
        }
        int i = 0;
        int j = 0;
        int n = nums.length;

        int requiredWindowSize = k+1;
        
        Map<Integer, Integer> fmap = new HashMap<>();
        while (j < n) {
            int windowSize = j-i+1;
            if(windowSize < requiredWindowSize) {
                if(fmap.containsKey(nums[j])) {
                    return true;
                }
                fmap.put(nums[j], 1);
                j++;
            } else {
                if(fmap.containsKey(nums[j])) {
                    return true;
                }
                while(windowSize >= requiredWindowSize) {
                    fmap.remove(nums[i]);
                    i++;
                    windowSize = j-i+1;
                }
                fmap.put(nums[j], 1);
                j++;
            }
        }
        return false;
    }
}