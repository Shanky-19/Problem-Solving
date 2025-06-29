class Solution {
    int max = 1000000007;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 0;
        int low=0;
        int high=n-1;
        int[] power = new int[n];
        power[0] = 1;
        for(int i=1;i<n;i++) {
            power[i] = (power[i-1] * 2)%max;
        }
        while(low <= high) {
            if(nums[low] + nums[high] <= target) {
                ans = (ans + power[high-low])%max;
                low++;
            }else {
                high--;
            }
        }
        return ans;
    }
}