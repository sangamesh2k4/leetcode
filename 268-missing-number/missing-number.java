class Solution {
    public int missingNumber(int[] nums) {
        int sum=0;
        for(int num : nums) sum+=num;
        int miss=(nums.length*(nums.length+1))/2;
        return miss-sum;
    }
}