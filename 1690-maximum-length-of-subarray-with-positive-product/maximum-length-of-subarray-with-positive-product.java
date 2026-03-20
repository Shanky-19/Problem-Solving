class Solution {
    /*
        For any subarray ending at index i, the only thing that matters is its sign, 
        not the exact product value. 
        If nums[i] > 0, a previous positive-product subarray stays positive, 
        and a previous negative-product subarray stays negative.
            If nums[i] < 0, the sign flips: positive becomes 
                negative and negative becomes positive.

            If nums[i] == 0, no valid subarray can continue 
                through it, so both lengths reset to 0.

        So at each index, it is enough to store just:

        pos = longest subarray ending here with positive product

        neg = longest subarray ending here with negative product

        This works because every new valid subarray ending at i 
        must come from extending one ending at i-1 or starting fresh at 
        i. That gives all possibilities, so taking the maximum pos 
        seen over the scan gives the answer.
    */
    public int getMaxLen(int[] nums) {
        int positive = 0;
        int negative = 0;

        int ans = 0;
        for(int val : nums) {
            if(val == 0) {
                positive = 0;
                negative = 0;
            } else if(val > 0) {
                positive++;
                negative = negative == 0 ? 0 : negative+1;
            } else {
                int temp = positive;
                positive = negative == 0 ? 0  : negative+1;
                negative = temp+1;
            }
            ans = Math.max(ans, positive);
        }
        return ans;
    }
}