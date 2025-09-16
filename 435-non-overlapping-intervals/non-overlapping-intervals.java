class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            return a[1]-b[1];
        });

        int count = 0;
        int i = 0;
        int j = i + 1;
        
        while (j < intervals.length) {
            int prevEnd = intervals[i][1];
            int nextStart = intervals[j][0];
            
            if(nextStart < prevEnd) {
                count++;
                j++;
            } else {
                i = j;
                j++;
            }
        }

        return count;
    }
}