class Solution {
    int m,n;
    void dfs(int row,int col,char[][] board){
        if(row<0|| row>=m|| col<0 || col>=n|| board[row][col]=='X'|| board[row][col]=='#'){
            return;
        }
        board[row][col]='#';
        dfs(row-1,col,board);
        dfs(row+1,col,board);
        dfs(row,col-1,board);
        dfs(row,col+1,board);
    }
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;
        for(int j=0;j<n;j++){
            if(board[0][j]=='O'){
                dfs(0,j,board);
            }
             if(board[m-1][j]=='O'){
                dfs(m-1,j,board);
            }
        }
         for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(i,0,board);
            }
             if(board[i][n-1]=='O'){
                dfs(i,n-1,board);
            }
        }

        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='#'){
                    board[i][j]='O';
                }
            }
        }
        return;
    }
}