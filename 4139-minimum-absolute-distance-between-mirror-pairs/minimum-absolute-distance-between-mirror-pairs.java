class Solution {

    private int findReverse(int val) {
        int rev = 0;
        while(val > 0) {
            int rem = val%10;
            rev = (rev*10) + rem;
            val = val/10;
        }
        return rev;
    }

    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> hm = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (hm.containsKey(nums[i])) {
                ans = Math.min(ans, i - hm.get(nums[i]));
            }
            hm.put(findReverse(nums[i]), i);
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}