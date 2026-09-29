class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftMax=height[left],rightMax=height[right];
        int water=0;
        while(left<right){
            if(leftMax<rightMax){
                left++;
                leftMax=Math.max(height[left],leftMax);
                water+=leftMax-height[left];
            }else{
                right--;
                rightMax=Math.max(rightMax,height[right]);
                water+=rightMax-height[right];
            }
        }
        return water;
    }
}