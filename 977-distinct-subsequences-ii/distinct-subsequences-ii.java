class Solution {
    private static final long MOD= 1_000_000_007L;
    public int distinctSubseqII(String s) {
        long total=0;
        long[] dp=new long[26];
        for(char c: s.toCharArray()){
            long old=dp[c-'a'];
            long newEnding=total+1;
            total=(2*total+1-old+MOD)%MOD;
            dp[c-'a']=newEnding%MOD;
        }
        return (int)total;
    }
}