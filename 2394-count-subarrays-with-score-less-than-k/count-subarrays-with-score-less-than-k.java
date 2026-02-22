class Solution {
    public long countSubarrays(int[] nums, long k) {
        int n = nums.length;
        int i = 0;
        int j = 0;
        long ans = 0;
        long sum = 0L;
        int length = 0;
        while (j < n) {
            int val = nums[j];
            sum += nums[j];
            length = j-i+1;

            while (sum * length >= k) {
                sum -= nums[i];
                length--;
                i++;
            }
            ans += (j-i+1);
            j++;
        }
        return ans;
    }
}