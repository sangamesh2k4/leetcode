class Solution {
    public int trap(int[] height) {
        int left=0,right=height.length-1,leftMax=height[left],rightMax=height[right];
        int answer=0;
        while(left<right){
            if(leftMax<rightMax){
                left++;
                leftMax=Math.max(leftMax,height[left]);
                answer+=leftMax-height[left];
            }else{
                right--;
                rightMax=Math.max(rightMax,height[right]);
                answer+=rightMax-height[right];
            }
        }return answer;
    }
}