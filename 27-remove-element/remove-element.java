class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        int j = nums.length-1;
        int ans = 0;
        for(int v : nums) {
            if(v != val) {
                ans++;
            }
        }
        while (i<j) {
            if(nums[i] == val && nums[j] == val) {
                j--;
            } else if (nums[i] == val && nums[j] != val) {
                nums[i] = nums[j];
                i++;
                j--;
            } else if (nums[j] == val && nums[i] != val) {
                j--;
            } else {
                // nums[i] != val & nums[j] != val
                i++;
            }
        }
        return ans;
    }
}