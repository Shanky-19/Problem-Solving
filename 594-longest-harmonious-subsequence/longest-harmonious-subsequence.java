class Solution {
    public int findLHS(int[] nums) {
        Arrays.sort(nums);
        int i = 0;
        int j = 0;
        int ans = 0;
        while(i<nums.length && j < nums.length) {
            int val2 = nums[j];
            int val1 = nums[i];
            if(val2 - val1 == 1) {
                ans = Math.max(ans, j-i+1);
                j++;
            }else if(val2 - val1 > 1){
                i++;
            } else {
                j++;
            }
        }
        return ans;
    }
}

