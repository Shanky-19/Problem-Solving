class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        int low = 0;
        int high = n*n;
        int ans = n*n;
        while (low <= high) {
            int mid = low + (high-low)/2;
            
            boolean isPossible = helper(grid, mid);

            if(isPossible) {
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private boolean helper(int[][] grid, int time) {
        int x = 0;
        int y = 0;
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];

        boolean isPossible = false;
        if(grid[x][y] <= time) {
            isPossible = dfs(x, y, n, time, grid, visited);
        }
        return isPossible;
    }

    int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};

    boolean isValid(int x, int y, int n) {
        return x>=0 && x<n && y>=0 && y<n;
    }

    private boolean dfs(int x, int y, int n, 
                        int time, int[][] grid, boolean[][] visited) {
        
        if(x == n-1 && y == n-1 && grid[x][x] <= time) {
            return true;
        }

        visited[x][y] = true;
        for (int[] d : dirs) {
            int nbrX = x + d[0];
            int nbrY = y + d[1];

            if(isValid(nbrX, nbrY, n) 
                && !visited[nbrX][nbrY] 
                && grid[nbrX][nbrY] <= time) {
                boolean isPossible = dfs(nbrX, nbrY, n, time, grid, visited);
                if(isPossible) {
                    return true;
                }
            }
        }
        return false;
    }
}