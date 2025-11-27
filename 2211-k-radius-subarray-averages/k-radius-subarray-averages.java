class Solution {
    public int[] getAverages(int[] nums, int k) {
        int si = 0;
        int ei = 2*k;
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        if(2*k >= n) {
            return ans;
        }

        int currIdx = k;
        long sumCurrWindow = 0L;
        for(int i=si;i<=ei;i++) {
            sumCurrWindow += nums[i];
        }
        while(currIdx < n-k) {
            long avg = sumCurrWindow/(2*k + 1);
            ans[currIdx] = (int)avg;
            currIdx++;
            ei++;
            if(ei < n) {
                sumCurrWindow += nums[ei];
            }
            sumCurrWindow -= nums[si];
            si++;
        }
        return ans;
    }
}