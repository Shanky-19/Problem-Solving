class Solution {

    public int houseRobber(int[] nums,int s,int e){
        int prev2 = nums[s];
        int prev = Math.max(nums[s],nums[s+1]);

        for(int i=s+2;i<=e;i++){
            int ans = Math.max(prev2+nums[i],prev);
            prev2 = prev;
            prev = ans;
        }
        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1){
            return nums[0];
        }else if(n == 2){
            return Math.max(nums[0],nums[1]);
        }

        // take first house and ignore last house
        int ans1 = houseRobber(nums,0,n-2);

        // ignore first house and take first house
        int ans2 = houseRobber(nums,1,n-1);

        return Math.max(ans1,ans2);
    }
}