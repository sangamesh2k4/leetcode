class Solution {
    int m,n;
    long sum;
    void dfs(int row,int col,int[][] grid){
        if(row<0 || row>=m || col<0 || col>=n ) return;
        if(grid[row][col]==0) return;
        sum+=grid[row][col];
        grid[row][col]=0;
        dfs(row,col-1,grid);
        dfs(row,col+1,grid);
        dfs(row+1,col,grid);
        dfs(row-1,col,grid);
    }
    public int countIslands(int[][] grid, int k) {
        m=grid.length;n=grid[0].length;
        sum=0;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]!=0){
                    sum=0;
                    dfs(i,j,grid);
                    if(sum%k==0) count++;
                }
            }
        }
        return count;
    }
}