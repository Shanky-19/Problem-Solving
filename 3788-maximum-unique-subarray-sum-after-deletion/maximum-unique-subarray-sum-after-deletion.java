class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int val : nums) {
            if(val > 0) {
                set.add(val);
            }
        }

        int max = Integer.MIN_VALUE;
        if(set.size() == 0) {
            for(int val : nums) {
                max = Math.max(val, max);
            }
            return max;
        }

        int ans = 0;
        for(int val : set) {
            ans += val;
        }
        return ans;
    }
}