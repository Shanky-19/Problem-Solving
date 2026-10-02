class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int k = 0; k < 32; k++) {
            int countOfOne = 0;
            for(int num : nums){
                countOfOne += (num>>k)&1; 
            }
            int kthBit = countOfOne%3;
            if(kthBit == 1){
                int bitmask = (1<<k);
                ans = (ans | bitmask);
            }
        }
        return ans;
    }
}