class Solution {
    int m,n;
    boolean dfs(int row,int col, int[][] grid){
        if(grid[row][col]==1) return true;
        if(row==0 || row==m-1 || col==0 || col==n-1 ) return false;
        grid[row][col]=1;
        boolean left=dfs(row-1,col,grid);
        boolean right=dfs(row+1,col,grid);
        boolean down=dfs(row,col-1,grid);
        boolean up=dfs(row,col+1,grid);

        return left&&right&&up&&down;

    }
    public int closedIsland(int[][] grid) {
        int islands=0;
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0 && dfs(i,j,grid)) islands++;
            }
        }
        return islands;
    }
}