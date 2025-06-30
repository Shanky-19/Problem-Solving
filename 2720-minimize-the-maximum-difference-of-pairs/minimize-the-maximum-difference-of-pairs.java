class Solution {


    public boolean blackBox(int[] nums,int mid,int p){
        int count = 0;
        int i = 0;
        while(i < nums.length-1 && count < p){
            if(nums[i+1] - nums[i] <= mid){
                count++;
                i+=2;
            }else{
                i++;
            }
        }
        return count >= p;
    }

    // Greedy + Binary Search
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        if(n == 1){
            return 0;
        }

        Arrays.sort(nums);
        
        int low = 0;
        int high = nums[n-1] - nums[0];

        while(low < high){
            int mid = (low + high)/2;

            if(blackBox(nums,mid,p)){
                high = mid;
            }else{
                low = mid + 1;
            }
        }
        return low;
    }
}