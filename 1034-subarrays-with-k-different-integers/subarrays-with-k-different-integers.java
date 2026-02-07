class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        int count1 = findCountOfSubarraysWithLessThanEqualKDifferentInteger(nums, k);
        int count2 = findCountOfSubarraysWithLessThanEqualKDifferentInteger(nums, k-1);
        return count1 - count2;
    }

    private int findCountOfSubarraysWithLessThanEqualKDifferentInteger 
        (int[] nums, int k) {
        
        int n = nums.length;
        Map<Integer, Integer> fmap = new HashMap<>();
        int i = 0;
        int j = 0;
        int count = 0;
        while (j < n) {
            int val = nums[j];
            fmap.put(val, fmap.getOrDefault(val, 0)+1);
            while(fmap.size() > k) {
                fmap.put(nums[i], fmap.get(nums[i])-1);
                if(fmap.get(nums[i]) == 0) {
                    fmap.remove(nums[i]);
                }
                i++;
            }
            count += (j-i+1);
            j++;
        }
        return count;
    }
}