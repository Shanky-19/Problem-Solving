class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0L;
        int i = 0;
        int j = 0;
        TreeMap<Integer, Integer> fmap = new TreeMap<>();
        while (j < n) {
            fmap.put(nums[j], fmap.getOrDefault(nums[j], 0) + 1);
            
            // to use lastKey and firstKey we need to use TreeMap reference
            // Map<Integer, Integer> fmap = new .. -> will not work
            int max = fmap.lastKey(); 
            int min = fmap.firstKey();

            while (fmap.lastKey() - fmap.firstKey() > 2) {
                fmap.put(nums[i], fmap.get(nums[i]) - 1);
                if(fmap.get(nums[i]) == 0) {
                    fmap.remove(nums[i]);
                }
                i++;
            }

            // here we have valid window
            ans += (j-i+1);
            j++;
        }
        return ans;
        
    }
}