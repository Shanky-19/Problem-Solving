class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {
            if(a[1]==b[1]) {
                return a[0]-b[0];
            } 
            return b[1]-a[1];
        });

        // for(int i=0;i<n;i++) {
        //     System.out.print(intervals[i][0] + " " + intervals[i][1]);
        //     System.out.println();
        // }

        int minSoFar = intervals[0][0];
        int maxSoFar = intervals[0][1];
        int covered = 0;
        for(int i=1;i<n;i++) {
            int[] intv = intervals[i];
            if(intv[0] >= minSoFar) {
                covered++;
            } 
            minSoFar = Math.min(minSoFar, intv[0]);
            maxSoFar = Math.max(maxSoFar, intv[1]);
        }
        return n - covered;
    }
}