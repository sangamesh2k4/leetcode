class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length, miss=(n*(n+1))/2;
        for(int i=0;i<n;i++) miss-=nums[i];
        return miss;
    }
}