class Solution {
    public boolean check(int[] nums) {
        // base case
        if(nums.length == 1){
            return true;
        }
        int n = nums.length;

        int dip = 0;
        for(int i=1;i<n;i++){
            if(nums[i] < nums[i-1]){
                dip++;
            }
        }
        if(nums[n-1] > nums[0]){
            dip++;
        }
        return dip<=1;
    }
}