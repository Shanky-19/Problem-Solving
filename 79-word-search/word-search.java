class Solution {

    public boolean dfs(int i,int j,char[][] board,String word,int idx,boolean[][] visited){
        if(idx == word.length()){
            return true;
        }
        
        if(i<0 || j< 0 || i==board.length || j == board[0].length || visited[i][j] || board[i][j] != word.charAt(idx)){
            return false;
        }

        visited[i][j] = true;
        boolean ans1 = dfs(i+1,j,board,word,idx+1,visited);
        if(ans1){
            return true;
        }
        boolean ans2 = dfs(i-1,j,board,word,idx+1,visited);
        if(ans2){
            return true;
        }
        boolean ans3 = dfs(i,j+1,board,word,idx+1,visited);
        if(ans3){
            return true;
        }
        boolean ans4 = dfs(i,j-1,board,word,idx+1,visited);
        if(ans4){
            return true;
        }

        visited[i][j] = false;
        return false;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        int idx = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(idx)){
                    boolean ans = dfs(i,j,board,word,idx,visited);
                    if(ans){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}