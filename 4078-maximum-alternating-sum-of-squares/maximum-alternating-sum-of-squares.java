class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i=0;i<n;i++) {
            nums[i] = nums[i] * nums[i];
        }

        Arrays.sort(nums);

        long ans = 0;
        int i = 0;
        int j = n-1;
        while(i < j) {
            ans += nums[j];
            ans -= nums[i];
            i++;
            j--;
        }
        if(i == j) {
            ans += nums[j];
        }
        return ans;

    }
}