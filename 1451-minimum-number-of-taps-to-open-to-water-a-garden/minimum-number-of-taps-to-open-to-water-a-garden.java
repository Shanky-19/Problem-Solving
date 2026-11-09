class Solution {
    public int minTaps(int n, int[] ranges) {
        
        int[] startEnd = new int[n+1];
        for(int idx=0;idx<ranges.length;idx++) {
            int start = Math.max(0, idx - ranges[idx]);
            int end = Math.min(n, idx + ranges[idx]);

            startEnd[start] = Math.max(startEnd[start], end);
        }

        int taps = 0;
        int currEnd = 0;
        int maxEnd = 0;

        for(int i=0;i<n+1;i++) {
            if(i > maxEnd) {
                return -1;
            }

            if(i > currEnd) {
                taps++;
                currEnd = maxEnd;
            }
            maxEnd = Math.max(maxEnd, startEnd[i]);
        }
        return taps;
    }
}