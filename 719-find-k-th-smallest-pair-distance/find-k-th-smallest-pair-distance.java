class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        
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

    }
}