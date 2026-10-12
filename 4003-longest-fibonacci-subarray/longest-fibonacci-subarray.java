class Solution {
    public int longestSubarray(int[] nums) {
        if(nums.length<3) return nums.length;
        int n=2;
        int curr=2;
        for(int i=2;i<nums.length;i++){
            if(nums[i]==nums[i-1]+nums[i-2]){
                curr++;
            }
            else{
                n=Math.max(curr,n);
                curr=2;
            }
        }
        return Math.max(curr,n);
    }
}