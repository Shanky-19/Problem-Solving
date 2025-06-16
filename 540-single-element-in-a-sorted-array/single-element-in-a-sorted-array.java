class Solution {
    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        return binarySearch(nums, low, high);
        
    }

    public int binarySearch(int[] nums, int low, int high) {
        while(low < high) {
            int mid = (high - low)/2 + low;

            if(mid-1>=0 && mid+1<nums.length 
                && nums[mid] != nums[mid-1] 
                && nums[mid] != nums[mid+1]) {
                return nums[mid];
            }
            else if(mid-1 >=0 && nums[mid] != nums[mid-1]) {
                if((mid-low)%2 != 0) {
                    // odd number of elements on left -> ans is on left
                    high = mid-1;
                } else {
                    low = mid;
                }
            } else if(mid+1 < nums.length && nums[mid] != nums[mid+1]) {
                if((high-mid)%2 !=0) {
                    // odd number of elements on right -> ans is on right
                    low = mid+1;
                } else {
                    high = mid;
                }
            }
        }
        return nums[low];
    }
}