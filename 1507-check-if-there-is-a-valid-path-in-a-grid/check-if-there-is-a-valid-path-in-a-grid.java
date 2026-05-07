class Solution {
    class Pair {
        int i;
        int j;
        
        public Pair (int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private void fill(Map<Integer, List<Pair>> map) {
        for(int i=1;i<=6;i++) {
            map.put(i, new ArrayList<>());
            Pair p1;
            Pair p2;
            if(i == 1) {
                p1 = new Pair(0,-1);
                p2 = new Pair(0,1);
            } else if(i == 2) {
                p1 = new Pair(-1,0);
                p2 = new Pair(1,0);
            } else if(i == 3) {
                p1 = new Pair(0,-1);
                p2 = new Pair(1,0);
            } else if(i == 4) {
                p1 = new Pair(0,1);
                p2 = new Pair(1,0);
            } else if(i == 5) {
                p1 = new Pair(0,-1);
                p2 = new Pair(-1,0);
            } else {
                p1 = new Pair(0,1);
                p2 = new Pair(-1,0);
            }
            map.get(i).add(p1);
            map.get(i).add(p2);
        }
    }

    boolean isValid (int i, int j, int n, int m) {
        return (i>=0 && i<n && j>=0 && j<m);
    }

    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        Map<Integer, List<Pair>> map = new HashMap<>();
        fill(map);

        boolean[][] visited = new boolean[n][m];
        boolean ans = dfs(grid, 0, 0, n, 
                            m, map, visited);
        return ans;
    }

    private boolean dfs(int[][] grid, int i,
                        int j, int n, int m,
                        Map<Integer, List<Pair>> map,
                        boolean[][] visited) {

        if(i == n-1 && j == m-1) {
            return true;
        }
        visited[i][j] = true;

        int point = grid[i][j];

        for(Pair nbr : map.get(point)) {
            int nextI = i + nbr.i;
            int nextJ = j + nbr.j;

            if(!isValid(nextI, nextJ, n, m) || 
                visited[nextI][nextJ]) {
                continue;
            }

            // The path should only follow the streets
            // Mean, we should come be to i, j 
            // from nextI, nextJ
            for(Pair backDir : map.get(grid[nextI][nextJ])) {
                if(nextI + backDir.i == i &&
                    nextJ + backDir.j == j) {
                    if(dfs(grid, nextI, nextJ, n, m,
                        map, visited)) {
                        return true;
                    }
                }
            }                 
        }
        return false;
    }
}