class Solution {


    public long findCost(int num,int[] cost,int[] nums){
        long totalCost = 0;
        for(int i=0;i<nums.length;i++){
            int val = nums[i];
            if(val != num){
                totalCost += (long)Math.abs(val-num) * cost[i];
            }
        }
        return totalCost;
    }
    public long minCost(int[] nums, int[] cost) {
        // imp point is the final array element might or might not
        // be present in current array.


        long ans = Long.MAX_VALUE;

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for(int val: nums){
            left = Math.min(left,val);
            right = Math.max(right,val);
        }

        while(left <= right){
            int mid = left + (right-left)/2;

            long cost1 = findCost(mid,cost,nums);
            long cost2 = findCost(mid+1,cost,nums);

            ans = Math.min(cost2,cost1);

            if(cost2 > cost1){
                right = mid-1;
            }else{
                left = mid + 1;
            }

        }

        return ans;
    }
}