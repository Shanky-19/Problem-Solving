// Brute Force : TLE
/*
class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;

        Map<Integer,Integer> fmap = new HashMap<>();
        for(int val : nums) {
            fmap.put(val, fmap.getOrDefault(val, 0) + 1);
        }

        for(int i=0;i<n;i++) {
            int val = nums[i];
            // try to make all adjacent 
            // elements of val equal to val
            int left = i-1;
            int right = i+1;
            long tempK = k;

            int count = fmap.get(val);

            while(left >= 0 && right < n && tempK > 0) {
                int op1 = Math.abs(val - nums[left]);
                int op2 = Math.abs(val - nums[right]);
                if(op1 < op2) {
                    if(tempK >= op1) {
                        tempK -= op1;
                        count++;
                        left--;
                    } else {
                        break;
                    }
                } else if(op2 >= op1){
                    if(tempK >= op2) {
                        tempK -= op2;
                        count++;
                        right++;
                    } else {
                        break;
                    }
                }
            }

            while(left >= 0 && tempK > 0) {
                int op1 = Math.abs(val - nums[left]);
                if(tempK >= op1) {
                    count++;
                    left--;
                    tempK -= op1;
                } else {
                    break;
                }
            } 

            while(right < n && tempK > 0) {
                int op2 = Math.abs(val - nums[right]);
                if(tempK >= op2) {
                    count++;
                    right++;
                    tempK -= op2;
                } else {
                    break;
                }
            } 

            ans = Math.max(ans, count);
        }
        return ans;
    }
}
*/


class Solution {
    public int maxFrequencyScore(int[] nums, long k) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = 0;

        long[] prefixSum = new long[n];
        prefixSum[0] = nums[0];
        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        
        int low = 1;
        int high = n;

        while (low <= high) {
            int mid = low + (high-low)/2;

            if(isPossible(nums, mid, k, prefixSum)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int[] nums, int windowSize,
                                 long k, long[] prefixSum) {
        int i = 0;
        int j = windowSize-1;
        while (j < nums.length) {
            int mid = (i + j)/2;
            long target = nums[mid];

            // we have to make all elements 
            // of this window equal to target

            long leftOperations = 0;
            if(mid-1 >= 0) {
                long leftOldSum = prefixSum[mid-1] - 
                                ((i==0) ? 0 : prefixSum[i-1]);
                long leftNewSum = target * (mid-i);
                leftOperations = Math.abs(leftNewSum - leftOldSum);
            }

            long rightOldSum = prefixSum[j] - prefixSum[mid];
            long righttNewSum = target * (j-mid);
            long rightOperations = Math.abs(righttNewSum - rightOldSum);

            if(leftOperations + rightOperations <= k) {
                return true;
            }
            i++;
            j++;
        }
        return false;

    }


}