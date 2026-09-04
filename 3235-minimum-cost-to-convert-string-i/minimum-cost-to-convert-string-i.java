class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] dp=new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dp[i],Long.MAX_VALUE);
            dp[i][i]=0;
        }
        for(int i=0;i<original.length;i++){
            int u=original[i]-'a';
            int v=changed[i]-'a';
            dp[u][v]=Math.min(dp[u][v],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
                if(dp[i][k]==Long.MAX_VALUE) continue;
                for(int j=0;j<26;j++){
                    if(dp[k][j]!=Long.MAX_VALUE){
                    dp[i][j]=Math.min(dp[i][k]+dp[k][j],dp[i][j]);
                    }
                }
            }
        }
        long totalcost=0;
        for(int i=0;i<source.length();i++){
            int u=source.charAt(i)-'a';
            int v=target.charAt(i)-'a';
            if(dp[u][v]==Long.MAX_VALUE) return -1;
            totalcost+=dp[u][v];
        }
        return totalcost;
    }
}