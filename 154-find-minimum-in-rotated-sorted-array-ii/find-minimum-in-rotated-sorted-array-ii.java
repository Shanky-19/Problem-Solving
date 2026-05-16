class Solution {
    public int findMin(int[] nums) {
        int ans = helper(nums,0,nums.length-1);
        return ans;
    }

    public int helper(int[] nums,int low,int high){
        while(low < high){
            int mid = (low + high)/2;
            if(nums[mid] > nums[high]){
                low = mid+1;
            }else if(nums[mid] < nums[high]){
                high=mid;
            }else{

                /* My approach
                if(nums[low] < nums[mid]){
                    high = mid-1;
                }else{ // nums[low] == nums[mid]
                    int min1 = helper(nums,low,mid);
                    int min2 = helper(nums,mid+1,high);
                    return Math.min(min1,min2);
                }
                */

                // Striver approach
                high--;

            }
        }
        return nums[low];
    }
}