class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for(int val : nums){
            min = Math.min(min,val);
        }
        int res = 0;
        for(int val : nums){
            res += val - min;
        }
        return res;
    }
}