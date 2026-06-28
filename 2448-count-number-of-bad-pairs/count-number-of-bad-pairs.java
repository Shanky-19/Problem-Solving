class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<n;i++) {
            int val = nums[i] - i;
            hm.put(val, hm.getOrDefault(val, 0)+1);
        }

        // find good pairs
        long goodPairs = 0;
        for(int key : hm.keySet()) {
            int val = hm.get(key);
            if(val >= 2) {
                goodPairs += (1L * val) * (val-1)/2; // nC2
            }
        }

        long totalPairs = 1L * n *(n-1)/2; // nC2
        return totalPairs - goodPairs;
     }
}
