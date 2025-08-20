class Solution {

    class Pair {
        int i;
        int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private boolean isValid (int row,int col, int n) {
        return (row >=0 && row < n && col >=0 && col<n);
    }

    private int[][] calculateSafenessFactorOfEachCell (List<List<Integer>> grid, int n) {
        int[][] safeness = new int[n][n];
        LinkedList<Pair> queue = new LinkedList<>();
        for (int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                safeness[i][j] = -1;
                if (grid.get(i).get(j) == 1) {
                    queue.addLast(new Pair(i,j));
                    // System.out.println(i + " " + j);
                }
            }
        }
        
        int distance = 0;
        while (queue.size() > 0) {
            int size = queue.size();
            while(size-- > 0) {
                // r m* w a*
                Pair p = queue.removeFirst();
                int i = p.i;
                int j = p.j;

                if(safeness[i][j] != -1) {
                    continue;
                }

                safeness[i][j] = distance;

                for (int[] d : dir) {
                    int newRow = i + d[0];
                    int newCol = j + d[1];
                    // valid and not visited
                    if(isValid(newRow, newCol, n) && safeness[newRow][newCol] == -1) {
                        queue.addLast(new Pair(newRow, newCol));
                    }
                }
            }
            distance++;
        }
        return safeness;
    }

    private boolean isPathWithSafenessAtMaxMid (
                                int mid, 
                                List<List<Integer>> grid,
                                int[][] safenessFactor
                                ) {
        int n = grid.size();
        int r = 0;
        int c = 0;
        boolean[][] visited = new boolean[n][n];
        if(safenessFactor[r][c] >= mid) {
            return dfs(r, c, n, mid, grid, visited, safenessFactor);
        }
        return false;
    }

    int[][] dir = {{-1,0}, {0, 1}, {1,0}, {0,-1}};

    private boolean dfs(int r, int c, int n,
                    int mid, List<List<Integer>> grid, 
                    boolean[][] visited, int[][] safenessFactor) {
        if(r == n-1 && c == n-1 && safenessFactor[r][c] >= mid) {
            return true;
        }
        visited[r][c] = true;
        for(int[] d : dir) {
            int newRow = r + d[0];
            int newCol = c + d[1];

            if(isValid(newRow, newCol, n) 
                && safenessFactor[newRow][newCol] >= mid
                && !visited[newRow][newCol]) {
                boolean ans = dfs(newRow, newCol, n, mid, 
                                grid, visited, safenessFactor);

                if(ans) {
                    return true;
                }
            }
        }
        return false;
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        // base-case
        if(grid.get(0).get(0) == 1 || grid.get(n-1).get(n-1) == 1) {
            return 0;
        }

        int[][] safenessFactor = calculateSafenessFactorOfEachCell(grid, n);

        // for(int i=0;i<n;i++) {
        //     for(int j=0;j<n;j++) {
        //         System.out.print(safenessFactor[i][j] + " ");
        //     }
        //     System.out.println();
        // }

        int low = 0;
        int high = Integer.MAX_VALUE;
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(isPathWithSafenessAtMaxMid(mid, grid, safenessFactor)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }


}