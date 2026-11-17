class Solution {
    int getCost(String s,int start,int end){
        int len=end-start+1,minCost=Integer.MAX_VALUE;
        for(int d=1;d<len;d++){
            if(len%d==0){
                int changes=0;
                for(int g=0;g<d;g++){
                    int left=start+g;
                    int right=start+g+(len/d-1)*d;
                    while(left<right){
                        if(s.charAt(left)!=s.charAt(right)) changes++;
                        left+=d;right-=d;
                    }
                }
                minCost=Math.min(minCost,changes);
            }
        }
        return minCost;
    }
    public int minimumChanges(String s, int k) {
        int n=s.length();
        int[][] cost=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++) cost[i][j]=getCost(s,i,j);
        }
        int INF=1_000_000_000;
        int[][] dp=new int[n+1][k+1];
        for(int[] row :dp) Arrays.fill(row,INF);
        dp[0][0]=0;
        for(int i=1;i<=n;i++){
            for(int j=1;j<=k;j++){
                for(int p=0;p<=i-2;p++){
                    if(dp[p][j-1]==INF) continue;
                    dp[i][j]=Math.min(dp[i][j],dp[p][j-1]+cost[p][i-1]);
                }
            }
        }
        return dp[n][k];
    }
}