class Solution {
    int[][] dp;
    int[] suffix;
    int n;
    int solve(int i ,int M){
        if(2*M>=n-i){
            return suffix[i];
        }
        if(dp[i][M]!=-1){
            return dp[i][M];
        }
        int best=0;
        for(int x=1;x<=2*M;x++){
            int nextM=Math.max(M,x);
            int opp=solve(i+x,nextM);
            best=Math.max(best,suffix[i]-opp);
        }
        return dp[i][M]=best;
    }
    public int stoneGameII(int[] piles) {
        n=piles.length;
        suffix=new int[n+1];
        for(int i=n-1;i>=0;i--){
            suffix[i]=suffix[i+1]+piles[i];
        }
        dp=new int[n][n+1];
       for(int[] row:dp){
        Arrays.fill(row,-1);
       }
       return solve(0,1);
    }
}