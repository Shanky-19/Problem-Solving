class Solution {
    public int maxValue(int n, int index, int maxSum) {
        int low = 0;
        int high = maxSum;
        if(n == maxSum) {
            return 1;
        }
        int ans = -1;
        while(low <= high) {
            int mid = low +  (high-low)/2;

            boolean isPossible = isPossible(n, index, maxSum, mid);
            if(isPossible) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int n, int idx, int maxSum, int mid) {
        int nums_idx = mid;
        long sum_left_of_idx = 0L;
        long sum_right_of_idx = 0L;
        // TLE
/*
        int nums_idx_1 = nums_idx - 1;
        int idx_1 = idx - 1;
        while(idx_1 >= 0) {
            // System.out.println("hi");
            if(nums_idx_1 > 0) {
                sum_left_of_idx += nums_idx_1;
                nums_idx_1--;
            }else {
                sum_left_of_idx += 1;
            }
            idx_1--;
        }

        int nums_idx_plus_1 = nums_idx - 1;
        int idx_plus_1 = idx + 1;
        while(idx_plus_1 < n) {
            // System.out.println("hi2");
            if(nums_idx_plus_1 > 0) {
                sum_right_of_idx += nums_idx_plus_1;
                nums_idx_plus_1--;
            }else {
                sum_right_of_idx += 1;
            }
            idx_plus_1++;
        }
        // System.out.println("hi3");
        // System.out.println(sum_left_of_idx + " " + nums_idx + " " + sum_right_of_idx);
*/

        long noOfIdxToLeft = idx;
        if(noOfIdxToLeft == 0) {
            sum_left_of_idx = 0L;
        } else {
            long left = mid-1;
            if(noOfIdxToLeft > left) {
                long diff = noOfIdxToLeft - left;
                sum_left_of_idx = (1L * (left) * (left + 1))/2 + diff;
            } else {
                long diff = left - noOfIdxToLeft;
                sum_left_of_idx = (1L * (left) * (left + 1))/2 - (1L * (diff) * (diff + 1))/2;
            }
        }

        long noOfIdxToRight = n - idx - 1;
        if(noOfIdxToRight == 0) {
            sum_right_of_idx = 0L;
        } else {
            long right = mid-1;
            if(noOfIdxToRight > right) {
                long diff = noOfIdxToRight - right;
                sum_right_of_idx = (1L * (right) * (right + 1))/2 + diff;
            } else {
                long diff = right - noOfIdxToRight;
                sum_right_of_idx = (1L * (right) * (right + 1))/2 - (1L * (diff) * (diff + 1))/2;
            }
        }
        
        // System.out.println(sum_left_of_idx + " " + nums_idx + " " + sum_right_of_idx);
        if(sum_left_of_idx + nums_idx + sum_right_of_idx <= maxSum) {
            return true;
        }
        return false;

    }
}