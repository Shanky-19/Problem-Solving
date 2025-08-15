// class Solution {
//     public int[][] dir = {{-1,0}, {0, 1}, {1, 0}, {0, -1}};
//     class Pair {
//         int r;
//         int c;

//         public Pair (int r, int c) {
//             this.r = r;
//             this.c = c;
//         }
//     }
//     public int latestDayToCross(int row, int col, int[][] cells) {
//         // make zero based matrix
//         for(int[] cell  : cells) {
//             cell[0] -= 1;
//             cell[1] -= 1;
//         }
//         int day = 0;

//         // Binary Search
//         int low = 0;
//         int high = cells.length - 1;
//         while (low <= high) {
//             int mid = low + (high-low)/2;
//             if(check(cells, row, col, mid)) {
//                 day = mid + 1;
//                 low = mid + 1;
//             } else {
//                 high = mid - 1;
//             }
//         }
//         return day;
//     }

//     private boolean check (int[][] cells, int rows, 
//                             int cols, int mid) {
//         int[][] grid = new int[rows][cols];
//         for(int i=0;i<=mid;i++) {
//             int r = cells[i][0];
//             int c = cells[i][1];
//             grid[r][c] = 1;
//         }
//         for(int c=0;c<grid[0].length;c++) {
//             if(grid[0][c] == 0 && bfs(grid, 0, c)) {
//                 return true;
//             }
//         }
//         return false;
//     }

//     private boolean bfs (int[][] grid, int row, int col) {
//         LinkedList<Pair> queue = new LinkedList<>();
//         queue.addLast(new Pair(row, col));
//         int rows = grid.length;
//         int cols = grid[0].length;
//         // boolean[][] visited = new boolean[rows][cols];
//         while(queue.size() > 0) {
//             // r m* w a*
//             Pair p = queue.removeFirst();
//             int r = p.r;
//             int c = p.c;

//             grid[r][c] = 1;

//             if(r == rows-1) {
//                 return true;
//             }
//             for(int[] d : dir) {
//                 int newRow = r + d[0];
//                 int newCol = c + d[1];
//                 if(isValid(newRow, newCol, rows, cols) 
//                     && grid[newRow][newCol] == 0 ) {
//                     // && !visited[newRow][newCol]) {
//                     queue.addLast(new Pair(newRow, newCol));
//                 }
//             }
//         }
//         return false;
//     }

//     private boolean isValid(int r, int c, int rows, int cols) {
//         return (r>=0 && r<rows && c>=0 && c<cols);
//     }


// }



class Solution {
    public boolean isPossible(int m, int n, int t, int[][] cells) {
        int[][] grid = new int[m + 1][n + 1]; // Grid representation
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; // Possible directions

        for (int i = 0; i < t; i++) {
            grid[cells[i][0]][cells[i][1]] = 1; // Mark cells from the given list as blocked
        }

        Queue<int[]> queue = new LinkedList<>();
        
        for (int i = 1; i <= n; i++) {
            if (grid[1][i] == 0) {
                queue.offer(new int[]{1, i}); // Start BFS from the top row
                grid[1][i] = 1; // Mark the cell as visited
            }
        }
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1]; // Current cell coordinates
            
            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1]; // Neighbor cell coordinates
                
                if (nr > 0 && nc > 0 && nr <= m && nc <= n && grid[nr][nc] == 0) {
                    grid[nr][nc] = 1; // Mark the neighbor cell as visited
                    
                    if (nr == m) {
                        return true; // Found a path to the bottom row
                    }
                    
                    queue.offer(new int[]{nr, nc}); // Add the neighbor cell to the queue for further exploration
                }
            }
        }
        
        return false; // Unable to find a path to the bottom row
    }

    public int latestDayToCross(int row, int col, int[][] cells) {
        int left = 0, right = row * col, latestPossibleDay = 0;
        
        while (left < right - 1) {
            int mid = left + (right - left) / 2; // Calculate the mid-day
            
            if (isPossible(row, col, mid, cells)) {
                left = mid; // Update the left pointer to search in the upper half
                latestPossibleDay = mid; // Update the latest possible day
            } else {
                right = mid; // Update the right pointer to search in the lower half
            }
        }
        
        return latestPossibleDay;
    }
}