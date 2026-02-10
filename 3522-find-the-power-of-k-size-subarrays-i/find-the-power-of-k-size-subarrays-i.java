class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int j = k-1;

        int[] results = new int[n-k+1];
        while(j < n) {
            int power = findPower(nums, i, j);
            results[i] = power;
            j++;
            i++;
        }
        return results;
    }

    private int findPower(int[] nums, int left, int right) {
        for(int i=left;i<right;i++) {
            if(nums[i+1] - nums[i] != 1) {
                return -1;
            }
        }
        return nums[right];
    }
}