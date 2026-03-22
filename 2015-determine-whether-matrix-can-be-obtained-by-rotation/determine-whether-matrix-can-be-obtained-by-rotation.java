class Solution {
    public boolean findRotation(int[][] matrix, int[][] target) {
        int n = matrix.length;
        for(int count=1;count<=4;count++){
            for(int i=0;i<n;i++){
                for(int j=0;i+j<n-1;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-j][n-1-i];
                    matrix[n-1-j][n-1-i] = temp;
                }
            }

            for(int i=0;i<n/2;i++){
                for(int j=0;j<n;j++){
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n-1-i][j];
                    matrix[n-1-i][j] = temp;
                }
            }
            
            boolean flag = true;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(matrix[i][j] != target[i][j]){
                        flag = false;
                        break;
                    }
                }
            }
            if(flag){
                return true;
            }
        }
        return false;
    }
}