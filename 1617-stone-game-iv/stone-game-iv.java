class Solution {
    boolean[] dp;
    public boolean winnerSquareGame(int n) {
        dp=new boolean[n+1];
        for(int i=0;i<=n;i++){
            for(int j=1;j*j<=i;j++){
                int square=j*j;

                if(!dp[i-square]){
                    dp[i]=true;
                    break;
                }
            }
        }
        return dp[n];
    }
}