class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less=0,n=nums.length,count=0;
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(nums[i]<target){
                less++;
            }else if(nums[i]==target){
                count++;
            }
        }
        for(int i=less;i<count+less;i++) list.add(i);
        return list;
    }
}