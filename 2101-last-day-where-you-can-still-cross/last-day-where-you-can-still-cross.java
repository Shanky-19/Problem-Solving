class Solution {
    public int[][] dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
    class Pair {
        int r;
        int c;

        public Pair (int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
    public int latestDayToCross(int row, int col, int[][] cells) {
        // make zero based matrix
        for(int[] cell  : cells) {
            cell[0] -= 1;
            cell[1] -= 1;
        }
        int day = 0;

        // Binary Search
        int low = 0;
        int high = cells.length - 1;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(check(cells, row, col, mid)) {
                day = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return day;
    }

    private boolean check (int[][] cells, int rows, 
                            int cols, int mid) {
        int[][] grid = new int[rows][cols];
        for(int i=0;i<=mid;i++) {
            int r = cells[i][0];
            int c = cells[i][1];
            grid[r][c] = 1;
        }
        for(int c=0;c<grid[0].length;c++) {
            if(grid[0][c] == 0 && dfs(grid, 0, c, new boolean[rows][cols])) {
                return true;
            }

            // if(grid[0][c] == 0 && bfs(grid, 0, c)) {
            //     return true;
            // }
        }
        return false;
    }

    private boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if(!isValid(r, c, grid.length, grid[0].length) 
            || visited[r][c] || grid[r][c] == 1) {
            return false;
        }
        if(r==grid.length-1) {
            return true;
        }
        visited[r][c]=true;
        for(int[] d : dir) {
            int newRow = r + d[0];
            int newCol = c + d[1];

            boolean isPossible = dfs(grid, newRow, newCol, visited);
            if(isPossible) {
                return true;
            }
        }
        return false;

    }

    private boolean bfs (int[][] grid, int row, int col) {
        LinkedList<Pair> queue = new LinkedList<>();
        queue.addLast(new Pair(row, col));
        int rows = grid.length;
        int cols = grid[0].length;
        // boolean[][] visited = new boolean[rows][cols];
        while(queue.size() > 0) {
            // r m* w a*
            Pair p = queue.removeFirst();
            int r = p.r;
            int c = p.c;

            grid[r][c] = 1;

            if(r == rows-1) {
                return true;
            }
            for(int[] d : dir) {
                int newRow = r + d[0];
                int newCol = c + d[1];
                if(isValid(newRow, newCol, rows, cols) 
                    && grid[newRow][newCol] == 0 ) {
                    // && !visited[newRow][newCol]) {
                    queue.addLast(new Pair(newRow, newCol));
                }
            }
        }
        return false;
    }

    private boolean isValid(int r, int c, int rows, int cols) {
        return (r>=0 && r<rows && c>=0 && c<cols);
    }


}


