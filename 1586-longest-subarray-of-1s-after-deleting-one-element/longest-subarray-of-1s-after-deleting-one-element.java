class Solution {
    public int longestSubarray(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int i = 0;
        int j = 0;
        int flip = 1;

        while (j < n) {
            int val = nums[j];
            if(val == 1) {
                j++;
            } else {
                if(flip > 0) {
                    flip--;
                    j++;
                } else {
                    while(nums[i] != 0) {
                        i++;
                    }
                    i++;
                    flip = 1;
                }
            }
            // we don't have to flip we have to delet
            // hence -> (j-i-1)
            ans = Math.max(ans, j-i-1);

        }
        return ans;
    }
}