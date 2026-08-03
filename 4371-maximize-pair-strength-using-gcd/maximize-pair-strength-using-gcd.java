class Solution {
    int findGcd(int a, int b){
        if (b == 0){
            return a;
        }
        return findGcd(b,a%b);
    }
    public long maxPairStrength(int[] nums) {
       long maxgcd=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            for( int j=i+1;j<nums.length;j++){
                int gcd=findGcd(nums[i],nums[j]);
                long strength=((long)nums[i]*nums[j])/(gcd*gcd);
                maxgcd=Math.max(strength,maxgcd);
            }
        }
        return maxgcd;
    }
}