class Solution {

    int[][] dir = {
        {-1,0},
        {0,1},
        {1,0},
        {0,-1},
    };

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(!visited[i][j] 
                    && isCycleDfs(grid, visited
                                ,i, j, 
                                i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCycleDfs(char[][] grid, 
                            boolean[][] visited, 
                            int i, int j,
                            int parentI,
                            int parentJ) {

        if(visited[i][j]) {
            return true;
        }

        visited[i][j] = true;

        for(int[] d : dir) {
            int nextI = i + d[0];
            int nextJ = j + d[1];
            if(isValid(nextI, nextJ, grid.length, grid[0].length)
                && grid[i][j] == grid[nextI][nextJ]) {
                
                if(parentI == nextI && parentJ == nextJ) {
                    continue;
                } else {
                    if (isCycleDfs(grid, visited, nextI, 
                                nextJ, i, j)) {
                        return true;
                    }
                }
            }
            
        }
        return false;
        
    }

    private boolean isValid(int i,int j, 
                            int n, int m) {
        return (i>=0 && i<n && j>=0 && j<m);
    }
}