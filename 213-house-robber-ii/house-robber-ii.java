class Solution {
    int robLiner(int[] nums,int start,int end){
        int prev2=nums[start];
        
        int prev1=Math.max(nums[start],nums[start+1]);
        int curr=0;
        for(int i=start+2;i<=end;i++) {
            curr=Math.max(prev1,nums[i]+prev2);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public int rob(int[] nums) {
    int n=nums.length;
    if(n==1) return nums[0];
    if(n==2) return Math.max(nums[0],nums[1]);
    int case1=robLiner(nums,0,n-2);
    int case2=robLiner(nums,1,n-1);
    return Math.max(case1,case2); 
    }
}