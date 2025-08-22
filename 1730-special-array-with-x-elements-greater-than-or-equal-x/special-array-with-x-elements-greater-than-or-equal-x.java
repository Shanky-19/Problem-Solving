class Solution {
    public int specialArray(int[] nums) {
        Arrays.sort(nums);
        int low = 1;
        int high = nums.length;

        for(int i=low;i<=high;i++) {
            int x = i;
            int count = checkGreaterThanX(nums, x);
            // System.out.println(x + " " + count);
            if(count == x) {
                return x;
            }
        }
        return -1;
    }

    private int checkGreaterThanX(int[] nums, int x) {
        int low = 0;
        int high = nums.length - 1;
        int idx = -1;
        while(low <= high) {
            int mid = low + (high - low)/2;

            if(nums[mid] >= x) {
                idx = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        if(idx == -1) {
            return 0;
        }
        return (nums.length - idx);
    }
}