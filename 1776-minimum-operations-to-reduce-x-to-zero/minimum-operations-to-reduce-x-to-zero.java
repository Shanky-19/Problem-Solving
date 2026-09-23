class Solution {
    public int minOperations(int[] nums, int x) {
     int target = -x;
        for(int i : nums) target+=i;
        if(target == 0) return nums.length;
        if(target < 0) return -1;
        int res = -1, sum = 0, left = 0;
        
        for(int r = 0; r < nums.length; r++) {
            sum+=nums[r];
            while(sum > target){
                sum-=nums[left++];
            }
            if(sum == target){
                res = Math.max(res, r-left+1);
            }
        }
        
        return res==-1 ? -1 : nums.length - res;
    }
}