class Solution {

    private int solve (int i, int j, int[][] grid) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return 0;
        }

        if(grid[i][j] == 0) {
            return 0;
        }

        int goldSoFar = grid[i][j];
        int temp = grid[i][j];
        grid[i][j] = 0;

        int gold1 = solve(i, j+1, grid);
        int gold2 = solve(i+1,j, grid);
        int gold3 = solve(i, j-1, grid);
        int gold4 = solve(i-1, j, grid);

        goldSoFar += Math.max(Math.max(Math.max(gold1, gold2), gold3), gold4);

        grid[i][j] = temp;
        return goldSoFar;
    }


    public int getMaximumGold(int[][] grid) {
        int n =grid.length;
        int m = grid[0].length;
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] != 0) {
                    ans = Math.max(ans, solve(i, j, grid));
                }
            }
        }
        return ans;
    }
}