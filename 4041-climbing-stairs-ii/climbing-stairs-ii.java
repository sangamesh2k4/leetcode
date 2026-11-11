class Solution {
    public int climbStairs(int n, int[] costs) {
        int prev3=0;
        if(n==1) return costs[0]+1;
        int prev2=costs[0]+1;
        int prev1=Math.min(prev2+costs[1]+1,prev3+costs[1]+4);
        if(n==2) return prev1;
        for(int i=3;i<=n;i++){
            int curr=Math.min(prev1+costs[i-1]+1,Math.min(prev2+costs[i-1]+4,prev3+costs[i-1]+9));
            prev3=prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}