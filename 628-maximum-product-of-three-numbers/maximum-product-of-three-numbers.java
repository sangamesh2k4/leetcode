class Solution {
    public int maximumProduct(int[] nums) {
        int firstmax=Integer.MIN_VALUE,secondmax=Integer.MIN_VALUE,thirdmax=Integer.MIN_VALUE,firstmin=Integer.MAX_VALUE,secondmin=Integer.MAX_VALUE;
        for(int num:nums){
            if(num>firstmax){
                thirdmax=secondmax;
                secondmax=firstmax;
                firstmax=num;
            }
            else if(num>secondmax){
                thirdmax=secondmax;
                secondmax=num;
            }
            else if(num>thirdmax){
                thirdmax=num;
            }
            if(num<=firstmin){
                secondmin=firstmin;
                firstmin=num;
            }
            else if(num<=secondmin){
                secondmin=num;
            }
        }
        return Math.max(firstmax*secondmax*thirdmax, firstmin*secondmin*firstmax);
    }
}