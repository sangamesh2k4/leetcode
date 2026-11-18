class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length, m=(n*(n+1))/2;
        for(int i=0;i<n;i++) m-=nums[i];
        return m;
    }
}