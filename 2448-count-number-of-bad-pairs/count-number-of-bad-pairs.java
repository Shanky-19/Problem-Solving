class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();
        long goodPairs = 0;
        for(int i=0;i<n;i++) {
            int val = nums[i] - i;
            int existing = hm.getOrDefault(val, 0);
            goodPairs += existing;
            hm.put(val, existing+1);
        }
        long totalPairs = 1L * n *(n-1)/2; // nC2
        return totalPairs - goodPairs;
     }
}
