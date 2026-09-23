class Solution {
    public int minDays(int[][] grid) {
    int[][] copy = new int[grid.length][grid[0].length];
    for(int i = 0; i < grid.length; i++) {
        copy[i] = grid[i].clone();
    }

    int islands = countIslands(copy);

    if(islands != 1) return 0;

    for(int r = 0; r < grid.length; r++) {
        for(int c = 0; c < grid[0].length; c++) {

            if(grid[r][c] == 1) {

                grid[r][c] = 0;

                int[][] temp = new int[grid.length][grid[0].length];

                for(int i = 0; i < grid.length; i++) {
                    temp[i] = grid[i].clone();
                }

                if(countIslands(temp) != 1) {
                    return 1;
                }

                grid[r][c] = 1;
            }
        }
    }

    return 2;
}

    void dfs(int r,int c,int[][] grid){
        if(r< 0 || r>=grid.length ||
        c<0 || c>=grid[0].length || grid[r][c]==0) return ;
        grid[r][c]=0;
        dfs(r-1,c,grid);
        dfs(r+1,c,grid);
        dfs(r,c-1,grid);
        dfs(r,c+1,grid);
    }
    int countIslands(int[][] grid){
        int count=0;
        for(int r=0;r<grid.length;r++){
            for(int c=0;c<grid[0].length;c++){
                if(grid[r][c]==1) {
                    count++;
                    dfs(r,c,grid);
                }
            }
        }
        return count;
    }
}