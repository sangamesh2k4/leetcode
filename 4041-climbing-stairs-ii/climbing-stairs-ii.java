class Solution {
    public int climbStairs(int n, int[] costs) {
        int[] dp=new int[n+1];
        dp[0]=0;
        if(n==1) return costs[0]+1;
        dp[1]=costs[0]+1;
        dp[2]=Math.min(dp[1]+costs[1]+1,dp[0]+costs[1]+4);
        if(n==2) return dp[2];
        for(int i=3;i<=n;i++) dp[i]=Math.min(dp[i-1]+costs[i-1]+1,Math.min(dp[i-2]+costs[i-1]+4,dp[i-3]+costs[i-1]+9));
        return dp[n];
    }
}