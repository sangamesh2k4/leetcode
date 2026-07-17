class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q=new LinkedList<>();
        int fresh=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if( grid[i][j]==1){
                    fresh++;
                }}}
                int minute=0;
                if(fresh==0){
                    return 0;
                }
                while(!q.isEmpty()){
                    minute++;
                    int size=q.size();
                    for(int i=0;i<size;i++){
                        int[] curr=q.poll();
                        int row=curr[0];
                        int column=curr[1];
                        int[][] directions = { {-1, 0},
                         {1, 0},  
                         {0, -1},  
                          {0, 1}
                          };
                        for(int[] dir:directions){
                        int newRow=row+dir[0];
                        int newCol=column+dir[1];
                        if(newRow >= 0 &&newRow < grid.length && newCol >= 0 &&
                        newCol < grid[0].length && grid[newRow][newCol] == 1)
                        {
                            grid[newRow][newCol] = 2;
                            fresh--;
                            q.offer(new int[]{newRow, newCol});
                            }
                            }
                    }
                }
                if(fresh == 0)
                 return minute-1;
else
    return -1;
    }
}