class Solution {
    public int maxMoves(int[][] grid) {
        int m=grid.length,n=grid[0].length;
        int[] dp=new int[m];
        for(int j=n-2;j>=0;j--){
            int[] curr=new int [m];
            for(int i=0;i<m;i++){
              if(i>0 && grid[i-1][j+1] > grid[i][j]) curr[i]=Math.max(curr[i],1+dp[i-1]);
              if(grid[i][j+1] > grid[i][j]) curr[i]=Math.max(curr[i],1+dp[i]);
              if(i<m-1 && grid[i+1][j+1]>grid[i][j]) curr[i]=Math.max(curr[i],1+dp[i+1]);
            }
            dp=curr;
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}