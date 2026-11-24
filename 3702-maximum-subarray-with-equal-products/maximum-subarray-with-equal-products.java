class Solution {
    private long gcd(long a,long b){
        while(b!=0L){
            long temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    private long lcm(long a,long b){
        return (a/gcd(a,b))*b;
    }
    public int maxLength(int[] nums) {
        int n=nums.length;
        int maxLen=0;
        for(int i=0;i<n;i++){
            long currProd=1L;
            long currGcd=nums[i];
            long currLcm=nums[i];
            for(int j=i;j<n;j++){
                if(currProd>1000000000000L/nums[j]) currProd=2000000000000L;
                else currProd*=nums[j];

                if(j>i){ 
                currGcd=gcd(currGcd,nums[j]);
                currLcm=lcm(currLcm,nums[j]);
                }

                if(currProd==currLcm*currGcd){
                    if(j-i+1>maxLen) maxLen=j-i+1;
                }
            }
        }
        return maxLen;
    }
}