class Solution {

    public boolean isSafe(int row,int col,char[][] board,int n){
        
        // row safe
        for(int c=col-1;c>=0;c--){
            if(board[row][c] == 'Q'){
                return false;
            }
        }

        // upper left diagonal safe
        int r = row;
        int c = col;
        while(r>=0 && c>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r--;
            c--;
        }

        // lower left diagonal safe
        r = row;
        c = col;
        while(r<n && c>=0){
            if(board[r][c] == 'Q'){
                return false;
            }
            r++;
            c--;
        }

        return true;
    }

    public void helper(int col,int n,char[][] board,List<List<String>> ans){
        if(col == n){
            List<String> list = new ArrayList<>();
            for(int row=0;row<n;row++){
                StringBuilder sb = new StringBuilder();
                for(char ch : board[row]){
                    sb.append(ch);
                }
                list.add(sb.toString());
            }
            ans.add(list);
            return;
        }

        for(int row=0;row<n;row++){
            if(isSafe(row,col,board,n)){
                board[row][col] = 'Q';
                helper(col+1,n,board,ans);
                board[row][col] = '.';
            }
        }

    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        int col = 0;
        char[][] board = new char[n][n]; // board
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j] = '.';
            }
        }
        helper(col,n,board,ans);
        return ans;
    }
}