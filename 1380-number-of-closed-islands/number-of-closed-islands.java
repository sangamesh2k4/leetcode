class Solution {
    int m,n;
    boolean dfs(int row,int col,int[][]grid){
        if(grid[row][col]==1){
            return true;
        }
        if(row==0 || row==m-1 || col==0 || col==n-1){
            return false;
        }
        grid[row][col]=1;
       boolean left= dfs(row-1,col,grid);
       boolean right= dfs(row+1,col,grid);
       boolean down=dfs(row,col-1,grid);
       boolean up= dfs(row,col+1,grid);

        return up && down && left && right;
    }
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int islands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0){
                    boolean res=dfs(i,j,grid);
                    if(res==true){
                        islands++;
                    }
                }
            }
        }
        return islands;
    }
}