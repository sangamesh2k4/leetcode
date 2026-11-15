class Solution {
    public int numOfSubarrays(int[] arr) {
        int even=1,odd=0,sum=0;
        final int MOD=1000000007;
        long ans=0;
        for(int x : arr){
            sum=(sum+x)%2;
            if(sum==1){
            ans=(ans+even)%MOD;
            odd++;
            }else{
                ans=(ans+odd)%MOD;
                even++;
            }
        }
        return (int) ans;
    }
}