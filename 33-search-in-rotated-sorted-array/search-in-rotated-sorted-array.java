class Solution {
    
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length-1;        
        // smallest element idx = pivot index (where rotation happened)
        int pivotIdx = findPivot(nums, low, high);
        System.out.println(pivotIdx);
        int idx1 = binarySearch(nums, low, pivotIdx, target);
        if(nums[idx1] == target) {
            return idx1;
        }
        int idx2 = binarySearch(nums, pivotIdx, high, target);
        if(nums[idx2] == target) {
            return idx2;
        }
        return -1;
    }

    private int findPivot(int[] nums, int low, int high) {
        while(low < high) {
            int mid = low + (high - low)/2;
            if(nums[mid] > nums[high]) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }

    private int binarySearch(int[] nums, int low, int high, int target) {
        while(low < high) {
            int mid = low + (high-low)/2;

            if(nums[mid] == target) {
                return mid;
            }else if(nums[mid] < target) {
                low = mid+1;
            }else {
                high = mid;
            }
        }
        return low;
    }
}