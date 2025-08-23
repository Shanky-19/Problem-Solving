class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        /*
        int n = nums.length;
        int max = nums[0];
        for(int i=1;i<n;i++) {
            max = Math.max(max, nums[i]);
        }
        int[] distToCount = new int[max+1];
        for(int i=0;i<n;i++) {
            for(int j=i+1;j<n;j++) {
                int dist = Math.abs(nums[i]-nums[j]);
                distToCount[dist]++;
            }
        }

        for(int i=0;i<distToCount.length;i++) {
            int count = distToCount[i];
            k -= count;
            if(k <= 0) {
                return i;
            }
        }
        return 0;
        */

        // Optimal approach
        Arrays.sort(nums);
        int n = nums.length;
        int low = 0;
        int high = nums[n-1];
        int ans = -1;
        while(low <= high) {
            int mid = low + (high-low)/2;

            int pairCount = findPairCount(nums, mid);
            if(pairCount >= k) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;

    }

    private int findPairCount(int[] nums,int distance) {
        int i = 0;
        int j = i+1;
        int n = nums.length;
        int pairCount = 0;
        while (j < n) {
            // sorted so abs not needed
            int dist = (nums[j]-nums[i]);
            if(dist > distance) {
                i++;
            } else {
                pairCount += j-i;
                j++;
            }
            if(i == j) {
                j++;
            }
        }
        return pairCount;
    }
}