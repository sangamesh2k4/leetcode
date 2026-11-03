class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int num :nums){
            if(num>max) max=num;
            sum+=num;
        }
        return nums.length*max-sum;
    }
}