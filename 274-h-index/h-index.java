class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int low = 0;
        int high = n;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;

            if(isPossible(mid, citations)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private boolean isPossible(int hIdx, int[] citations) {
        int ans = 0;
        for(int val : citations) {
            if(val >= hIdx) {
                ans++;
            }
        }
        return (ans>=hIdx);
    }
}