class Solution {
    public int missingNumber(int[] nums) {
        int miss=(nums.length*(nums.length+1))/2;
        for(int num : nums) miss-=num;
        return miss;
    }
}