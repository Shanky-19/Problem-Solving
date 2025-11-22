class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for(int val : nums) {
            int rem = val%3;
            ans += Math.min(rem,3-rem);
        }
        return ans;
    }
}