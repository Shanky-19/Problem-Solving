class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=nums.length-1;
        int ans = Integer.MIN_VALUE;
        while(i < j){
            
            int sum = nums[i] + nums[j];
            ans = Math.max(sum,ans);
            
            i++;
            j--;
        }

        return ans;
    }
}