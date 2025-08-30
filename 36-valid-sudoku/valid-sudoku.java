class Solution {

    public boolean isSafe(char[][] board,int row,int col,char val){
        int n = board.length;
        int m = board[0].length;
        // row safety
        for(int j=0;j<m;j++){
            if(j != col && board[row][j] == val){
                return false;
            }
        }

        // col safety
        for(int i=0;i<n;i++){
            if(i != row && board[i][col] == val){
                return false;
            }
        }

        // 3X3 matrix safety
        int cornerx = row/3 * 3;
        int cornery = col/3 * 3;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[cornerx+i][cornery+j] == val && (cornerx+i)!=row && (cornery+j)!=col){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] != '.'){
                    boolean isSafe = isSafe(board,i,j,board[i][j]);
                    if(!isSafe){
                        return false;
                    }
                }
            }
        }
        return true;
    }
}