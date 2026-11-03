class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>max) max=nums[i];
            sum+=nums[i];
        }
        return nums.length*max-sum;
    }
}