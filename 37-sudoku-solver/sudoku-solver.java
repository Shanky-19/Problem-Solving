class Solution {
    
    public void display(char[][] board){
        for(int i = 0; i < board.length; i++){
          for(int j = 0; j < board[0].length; j++){
            System.out.print(board[i][j] + " ");
          }
          System.out.println();
        }
    }
    
    
    public boolean isSafe(char[][] board,int i,int j,int val){
        // row safety
        for(int ii=0;ii<board.length;ii++){
            if(board[ii][j] == (char)('0'+val)){
                return false;
            }
        }
        
        for(int jj=0;jj<board.length;jj++){
            if(board[i][jj] == (char)('0'+val)){
                return false;
            }
        }
        
        int cornerx = i/3 * 3;
        int cornery = j/3 * 3;
        
        for(int ii=0;ii<3;ii++){
            for(int jj=0;jj<3;jj++){
                if(board[cornerx + ii][cornery + jj] == (char)('0'+val)){
                    return false;
                }   
            }
        }
        
        return true;
    }
    
    boolean status = false;
    public void helper(char[][] board,int i,int j){
        if(i == board.length){
            // display(board);
            status = true;
            return;
        }
        
        int nexti = 0;
        int nextj = 0;
        
        if(j == board.length - 1){
            nexti = i+1;
            nextj = 0;
        }else{
            nexti = i;
            nextj = j+1;
        }
        if(board[i][j] != '.'){
            helper(board,nexti,nextj);
        }else{
            for(int val=1;val<=9;val++){
                if(isSafe(board,i,j,val)){
                    board[i][j] = (char)('0' + val);
                    helper(board,nexti,nextj);
                    if(status){
                        return;
                    }
                    board[i][j] = '.';
                }
            }
        }
    }
    
    public void solveSudoku(char[][] board) {
        helper(board,0,0);
    }
}