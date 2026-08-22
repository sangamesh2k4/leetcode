class Solution {
    public boolean checkDivisibility(int n) {
        int product=1,sum=0;
        int org=n;
        while(n>0){
            int digit=n%10;
            product*=digit;
            sum+=digit;
            n/=10;
        }
        return org%(sum+product)==0;
    }
}