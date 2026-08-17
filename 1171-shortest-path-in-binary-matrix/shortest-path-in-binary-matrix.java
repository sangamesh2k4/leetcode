class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0]==1) return -1;
        if(grid.length==1 && grid[0].length==1) return 1;
        int distance=0;
        Queue<int[]> queue=new LinkedList<>();
        queue.offer(new int[]{0,0,1});
        grid[0][0]=1;
        int[][] directions=new int[][]{{0,1},{0,-1},{1,0},{-1,0},{-1,-1},{-1,1},{1,1},{1,-1}};
        while(!queue.isEmpty()){
            int[] curr=queue.poll();
            int row=curr[0];
            int col=curr[1];
            int dist=curr[2];
            for(int[] dir:directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(newRow<0 || newRow>=grid.length || newCol<0 || newCol>=grid[0].length){
                    continue;
                }
                else if(grid[newRow][newCol]==1){
                    continue;
                }
                else{
                    grid[newRow][newCol]=1;
                    queue.offer(new int[]{newRow,newCol,dist+1});
                }
                if(newRow==grid.length-1 && newCol==grid[0].length-1){
                    return dist+1;
                }
            }
        }
        return -1;
    }
}