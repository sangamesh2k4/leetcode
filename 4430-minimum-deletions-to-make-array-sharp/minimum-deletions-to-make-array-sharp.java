class Solution {
    public int minDeletions(int[] nums) {
        int right=1,count=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[right]) count++;
            right++;
        }
        return count;
    }
}