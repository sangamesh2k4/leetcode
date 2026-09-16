class Solution {
    public int numberOfSets(int n, int k) {
        int MOD=1_000_000_007;
        int N=n+k-1;
        int R=2*k;
        long[][] comb=new long[N+k][R+1];
        comb[0][0]=1;
        for(int i=0;i<=N;i++){
            comb[i][0]=1;
            for(int j=1;j<=Math.min(i,R);j++){
                comb[i][j]=(comb[i-1][j-1]+comb[i-1][j])%MOD;
            }
        }
        return (int)comb[N][R];
    }
}