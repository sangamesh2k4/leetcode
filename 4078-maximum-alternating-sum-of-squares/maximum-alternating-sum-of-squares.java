class Solution {
    public long maxAlternatingSum(int[] nums) {
        int[] sq=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            sq[i]=nums[i]*nums[i];
        }
        Arrays.sort(sq);
        long ans=0;
        int k=sq.length/2;
        for(int i=0;i<k;i++){
            ans-=sq[i];
        }
        
        for(int i=k;i<sq.length;i++){
            ans+=sq[i];
        }
        return ans;
    }
}