class Solution {
    public boolean hasValidPath(char[][] grid) {
        if(grid[0][0]==')' || (grid.length+grid[0].length-1)%2!=0)return false;
    Queue<int[]> queue=new ArrayDeque<>();
    queue.offer(new int[]{0,0,1});
    boolean[][][] visited=new boolean[grid.length][grid[0].length][grid.length+grid[0].length];
    visited[0][0][1]=true;
    int[][] directions={{1,0},{0,1}};
    while(!queue.isEmpty()){
        int[] curr=queue.poll();
        int row=curr[0];
        int col=curr[1];
        int bal=curr[2];
        if( row == grid.length-1 && col==grid[0].length-1 && bal==0) return true;
        for(int[] dir :directions){
            int newRow=row+dir[0];
            int newCol=col+dir[1];
            if(newRow>=grid.length || newCol>=grid[0].length) continue;
            int newBal=bal;
            if(grid[newRow][newCol]==')'){
                newBal--;
            }else{
                newBal++;
            }
            if(newBal<0) continue;
            if(visited[newRow][newCol][newBal]) continue;
            visited[newRow][newCol][newBal]=true;
            queue.offer(new int[]{newRow,newCol,newBal});
        }
    }
    return false;
    }
}