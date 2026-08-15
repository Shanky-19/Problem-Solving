class Solution {
    public int longestSubsequence(int[] nums) {
        int ans = nums.length;

        int nonZero = 0; 
        int xor = 0; 
        
        for(int x: nums) {
            xor ^= x; 
            if(x != 0) {
                nonZero++;
            }
        }
        if(xor != 0) {
            return ans;
        }

        // case of all values are zero 
        if(nonZero == 0) {
            return 0;
        }
        return ans - 1; 
    }
}