class Solution {
    public int maxProduct(int[] nums) {
        int firstmax=Integer.MIN_VALUE,secondmax=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>firstmax){
                secondmax=firstmax;
                firstmax=num;
            }
            else if(num>secondmax){
                secondmax=num;
            }
        }
        return (firstmax-1)*(secondmax-1);
    }
}