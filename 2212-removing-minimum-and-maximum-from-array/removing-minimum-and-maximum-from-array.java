class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int minIdx=0,maxIdx=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]<nums[minIdx]) minIdx=i;
            if(nums[i]>nums[maxIdx]) maxIdx=i;
        }
        int left=Math.min(maxIdx,minIdx);
        int right=Math.max(minIdx,maxIdx);

        int fromFront=right+1;
        int fromBack=n-left;
        int fromBoth=left+1+n-right;
        return Math.min(fromFront,Math.min(fromBack,fromBoth));
    }
}