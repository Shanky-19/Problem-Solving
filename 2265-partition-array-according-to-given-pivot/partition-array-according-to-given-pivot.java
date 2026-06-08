class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int i = 0;
        int j = n-1;

        int lower = 0;
        for(int val : nums) {
            if(val < pivot) {
                lower++;
            }
        }
        int k = lower;
        int[] ans = new int[n];
        for(int val : nums) {
            if(val < pivot) {
                ans[i] = val;
                i++;
            } else if(val == pivot) {
                ans[k] = val;
                k++;
            } else {
                ans[j] = val;
                j--;
            }
        }

        int low = k;
        int high = n-1;
        while (low < high) {
            int temp = ans[low];
            ans[low] = ans[high];
            ans[high] = temp;
            low++;
            high--;
        }
        return ans;
    }
}