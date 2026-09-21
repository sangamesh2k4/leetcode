class Solution {
    public long[] resultArray(int[] nums, int k) {
        int[] dp=new int[k];
        long[] ans=new long[k];
        for(int x: nums){
            int[] next=new int[k];
            next[x%k]++;
            for(int r=0;r<k;r++){
                next[(r*(x%k))%k]+=dp[r];
            }
            for(int r=0;r<k;r++){
                ans[r]+=(long) next[r];
            }
            dp=next;
        }
        return ans;
    }
}