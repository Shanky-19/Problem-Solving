class Solution {
    public int minimumArea(int[][] grid) {
        int lowestRow = Integer.MAX_VALUE;
        int lowestCol = Integer.MAX_VALUE;
        int highestRow = -1;
        int highestCol = -1;

        int n = grid.length;
        int m = grid[0].length;

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) {
                    lowestRow = Math.min(lowestRow, i);
                    lowestCol = Math.min(lowestCol, j);
                    highestRow = Math.max(highestRow, i);
                    highestCol = Math.max(highestCol, j);
                }
            }
        }

        // The input is generated such that there is at least one 1 in grid.

        int len = highestRow - lowestRow + 1;
        int bre = highestCol - lowestCol + 1;
        return (len*bre);
    }
}