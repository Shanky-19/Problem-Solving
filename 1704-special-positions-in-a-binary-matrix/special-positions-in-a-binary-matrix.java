class Solution {
    public int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Map<Integer, Integer> rowMap = new HashMap<>();
        Map<Integer, Integer> colMap = new HashMap<>();
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1) {
                    rowMap.put(i, rowMap.getOrDefault(i, 0) + 1);
                    colMap.put(j, colMap.getOrDefault(j, 0) + 1);
                }
            }
        }
        int count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(mat[i][j] == 1) {
                    if(rowMap.get(i) == 1 && colMap.get(j) == 1) {
                        count++;
                    } 
                }
            }
        }
        return count;
    }
}