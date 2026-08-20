class Solution {
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b) ->a[2]-b[2]);
        int[][] effort=new int[heights.length][heights[0].length];
        for(int[] row: effort){
        Arrays.fill(row,Integer.MAX_VALUE);
        }
        effort[0][0]=0;
        pq.offer(new int[]{0,0,0});
        int[][] directions= {{0,-1},{0,1},{1,0},{-1,0}};
        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int row=curr[0];
            int col=curr[1];
            int curreffort=curr[2];
            for(int[] dir:directions){
                int newRow=row+dir[0];
                int newCol=col+dir[1];
                if(newCol<0 || newCol>=heights[0].length || newRow<0 || newRow>=heights.length){
                    continue;
                }
                int diff=Math.abs(heights[row][col]-heights[newRow][newCol]);
                int newEffort=Math.max(curreffort,diff);
                if(newEffort<effort[newRow][newCol]){
                    effort[newRow][newCol]=newEffort;
                    pq.offer(new int[] {newRow,newCol,newEffort});
                }
            }
            if(row==heights.length-1 && col==heights[0].length-1 ) return curreffort;
        }
        return 0;
    }
}