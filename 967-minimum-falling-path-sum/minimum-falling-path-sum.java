class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix[0].length;
        int[] dp=new int[n];
        for(int i=0;i<n;i++) dp[i]=matrix[n-1][i];

        for(int i=n-2;i>=0;i--){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int min=dp[j];
                if(j>0){
                    min=Math.min(min,dp[j-1]);
                }if(j<n-1){
                    min=Math.min(dp[j+1],min);
                }
                curr[j]=matrix[i][j]+min;
            }
            dp=curr;
        }
        int minCost=Integer.MAX_VALUE;
        for(int num :dp){
            if(num<minCost)minCost=num;
        }
        return minCost;
    }
}