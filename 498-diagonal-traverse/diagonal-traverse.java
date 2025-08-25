class Solution {
    
    private boolean isValid(int i,int j, int rows, int cols) {
        return (i >= 0 && i < rows && j >= 0 && j < cols);
    }
    
    public int[] findDiagonalOrder(int[][] mat) {
        int i = 0;
        int j = 0;
        boolean up = true;
        boolean down = false;
        int m = mat.length;
        int n = mat[0].length;
        int count = 0;
        int[] ans = new int[m*n];

        while(count < (m*n)) {
            ans[count] = mat[i][j];
            if(up) {
                if(isValid(i-1, j+1, m, n)) {
                    i--;
                    j++;
                } else if(isValid(i, j+1, m, n)) {
                    j++;
                    up = false;
                    down = true;
                } else if (isValid(i+1, j, m, n)) {
                    i++;
                    up = false;
                    down = true;
                }
            } else {
                if(isValid(i+1, j-1, m, n)) {
                    i++;
                    j--;
                } else if(isValid(i+1, j, m, n)) {
                    i++;
                    up = true;
                    down = false;
                } else if (isValid(i, j+1, m, n)) {
                    j++;
                    up = true;
                    down = false;
                }
            }
            count++;
        }
        return ans;
    }
}