class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        // potential answers
        int ans1 = Integer.MIN_VALUE; // linear subarray
        int ans2 = Integer.MIN_VALUE; // circular subarray

        // linear subarray -> kadane's algo
        int sum = 0;
        for(int i=0;i<nums.length;i++){
            sum = Math.max(nums[i],sum + nums[i]);
            ans1 = Math.max(ans1,sum);
        }
        

        // circular subarry 
        /*   ---              ----    => ans -> [4 -1 2 1] => 6
            [2 1 -5 4 -3 1 -3 4 -1]
            ans = Total sum - sum([-5,4,-3,1,-3])
            so except ans subarray, remaining sequence (min sum sequence)-> -5 4 -3 1 -3

            reverse the sign of each elements so -> min sum sequence changes to max sum sequence
            -2 -1 5 -4 -3 1 -3 4 -1
                  ------------

            now this max sum sequence can be found using kadane's algo.
            and total - ans(kadanes algo) = ans2
        */

        int total = 0;
        for(int i=0;i<nums.length;i++){
            total += nums[i];
            nums[i] *= -1;
        }
        sum = 0;
        int tempAns = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            sum = Math.max(nums[i],sum + nums[i]);
            tempAns = Math.max(tempAns,sum);
        }
        ans2 = total + tempAns;
        if(ans2 == 0){
            return ans1;
        }
        return Math.max(ans1,ans2);

    }
}