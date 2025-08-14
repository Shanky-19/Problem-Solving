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

        int low = nums[0];
        int high = nums[0];

        for(int val: nums){
            low = Math.min(low,val);
            high = Math.max(high,val);
        }

        while(low <= high){
            int mid = low + (high-low)/2;

            long cost1 = findCost(mid,cost,nums);
            long cost2 = findCost(mid+1,cost,nums);

            ans = Math.min(cost2,cost1);

            if(cost2 > cost1){
                high = mid-1;
            }else{
                low = mid + 1;
            }

        }
        return ans;
    }
}