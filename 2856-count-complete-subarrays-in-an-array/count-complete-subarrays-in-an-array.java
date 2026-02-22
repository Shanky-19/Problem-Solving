class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        int i = 0;
        int j = 0;

        Set<Integer> set = new HashSet<>();
        for(int val : nums) {
            set.add(val);
        }
        int k = set.size();// distinct

        Map<Integer, Integer> fmap = new HashMap<>();
        int ans = 0;
        while (j < n) {
            int val = nums[j];
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);

            while (fmap.size() == k) {
                ans += n - j;
                fmap.put(nums[i], fmap.get(nums[i]) - 1);
                if(fmap.get(nums[i]) == 0) {
                    fmap.remove(nums[i]);
                }
                i++;
            }   
            j++;
        }
        return ans;
    }
}