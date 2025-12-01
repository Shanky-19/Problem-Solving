/*
class Solution {
    public int maxFrequency(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] prefixSum = new int[n];
        prefixSum[0] = nums[0];
        int ans = 0;
        for(int i=1;i<n;i++) {
            prefixSum[i] = prefixSum[i-1] + nums[i];
        }
        for(int i = 0;i<n;i++) {
            int freq = bsearch(i, nums, k, prefixSum);
            ans = Math.max(ans, freq);
        }
        return ans;
    }

    private int bsearch(int targetIdx, int[] nums, int k, int[] prefixSum) {
        int low = 0;
        int high = targetIdx;
        int ans = 0;
        while(low <= high) {
            int mid = low + (high-low)/2;
            int windowSize = targetIdx - mid + 1;
            int windowSum = windowSize * nums[targetIdx];
            int originalSum = prefixSum[targetIdx] - ((mid-1 >= 0) ? prefixSum[mid-1] : 0);

            int operations = windowSum - originalSum;
            if(operations > k) {
                low = mid + 1;
            } else {
                ans = mid;
                high = mid-1;
            }
        }
        return (targetIdx - ans + 1);
    }
}
*/


//Approach-2 (Using sliding window)
//T.C : O(nlogn)
//S.C : O(1)
public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        
        int n = nums.length;
        
        int result = 0;
        
        int i = 0;
        long currSum = 0;
        
        for (int j = 0; j < n; j++) {
            
            long target = nums[j];
            currSum += nums[j];
            
            while ((j - i + 1) * target - currSum > k) {
                currSum -= nums[i];
                i++;
            }
            
            result = Math.max(result, j - i + 1);
            
        }
        return result;
    }
}