class Solution {
    Integer[] memo;
    private int solve(int[] stoneValue, int i){
        if(i>=stoneValue.length){
            return 0;
        }
        if(memo[i]!=null) return memo[i];
        int sum=0;
        int best=Integer.MIN_VALUE;
        for(int k=0;k<3&&i+k<stoneValue.length;k++){
            sum+=stoneValue[i+k];
            best=Math.max(best,sum-solve(stoneValue,i+k+1));
        }
        return memo[i]=best;
    }
    public String stoneGameIII(int[] stoneValue) {
        int n=stoneValue.length;
        memo=new Integer[n];
        int diff=solve(stoneValue,0);
        if(diff>0) return "Alice";
        if(diff<0) return "Bob";
        return "Tie";
    }
}