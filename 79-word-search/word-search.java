class Solution {

    public boolean dfs(int i,int j,char[][] board,
                        String word,int idx){
        if(idx == word.length()){
            return true;
        }
        
        if(i<0 || j< 0 || i==board.length || j == board[0].length 
            || board[i][j] == '#' || board[i][j] != word.charAt(idx)){
            return false;
        }
        char tempChar = board[i][j];
        board[i][j] = '#';
        boolean ans1 = dfs(i+1,j,board,word,idx+1);
        if(ans1){
            return true;
        }
        boolean ans2 = dfs(i-1,j,board,word,idx+1);
        if(ans2){
            return true;
        }
        boolean ans3 = dfs(i,j+1,board,word,idx+1);
        if(ans3){
            return true;
        }
        boolean ans4 = dfs(i,j-1,board,word,idx+1);
        if(ans4){
            return true;
        }

        board[i][j] = tempChar;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int idx = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(idx)){
                    boolean ans = dfs(i,j,board,word,idx);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}