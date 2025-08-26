class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int maxDiagonal = 0;
        for(int[] dim : dimensions) {
            int lenDiagonal = dim[0]*dim[0] + dim[1]*dim[1];
            if(lenDiagonal > maxDiagonal || 
                (lenDiagonal == maxDiagonal && dim[0] * dim[1] > ans)) {
                maxDiagonal = lenDiagonal;
                ans = dim[0] * dim[1];
            }
        }
        return ans;
    }
}