class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int solve(int i, int j, int[][] grid, 
                int nonObstacleSoFar, int nonObstacle) {
    
        if(i < 0 || j < 0 || i == grid.length 
                || j == grid[0].length || grid[i][j] == -1) {
            return 0;
        }

        if(grid[i][j] == 2) {
            if(nonObstacleSoFar == nonObstacle) {
                return 1;
            } else {
                return 0;
            }
        }

        int temp = grid[i][j];
        grid[i][j] = -1; //visited
        int ans = 0;
        for(int[] d : dir) {
            int newI = i + d[0];
            int newJ = j + d[1];

            ans += solve(newI, newJ, grid, nonObstacleSoFar + 1, nonObstacle);
        }
        
        grid[i][j] = temp;
        return ans;
    }

    public int uniquePathsIII(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int obstacles = 0;
        int startI = 0;
        int startJ = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == -1) {
                    obstacles++;
                } else if(grid[i][j] == 1) {
                    startI = i;
                    startJ = j;
                }
            }
        }

        int nonObstacle = (n*m) - obstacles;
        
        int nonObstacleSoFar = 1; // starting cell
        int ans = solve(startI, startJ, grid, nonObstacleSoFar, nonObstacle);
        return ans;
    }
}