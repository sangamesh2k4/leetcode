class Solution {
    public long sumAndMultiply(int n) {
        int num=0,place=1,sum=0;
        while (n > 0) {
    int digit = n % 10;
    if (digit != 0) {
        sum += digit;
        num += digit * place;
        place *= 10;
    }
    n /= 10;
}
return (long)num*sum;
    }
}