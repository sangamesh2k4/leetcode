class Solution {
    public int minMergedInteger(int[] nums) {
        int minPair=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i+=2){
            String s=""+nums[i]+nums[i+1];
            int pair=Integer.parseInt(s);
            minPair=Math.min(pair,minPair);
        }
        return minPair;
    }
}