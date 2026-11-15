class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long idealSum = 0;
        long noOfXor = 0;
        long minLoss = Integer.MAX_VALUE;
        for(int val : nums) {
            int temp = val ^ k;

            if(temp <= val) {
                idealSum += val;
            } else {
                // temp > val
                idealSum += temp;
                noOfXor++;
            }
            minLoss = Math.min(minLoss, Math.abs(val - temp));
        }

        if(noOfXor%2 != 0) {
            return idealSum - minLoss;
        }
        return idealSum;

    }
}