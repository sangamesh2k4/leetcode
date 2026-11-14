class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int min=Integer.MAX_VALUE;
        while(l<=r){
            int sum=0;
            for(int i=0;i<l;i++) sum+=nums.get(i);
            if(sum<min && sum>0) min=sum;
            for(int i=l;i<nums.size();i++){
                sum-=nums.get(i-l);
                sum+=nums.get(i);
                if(sum<min && sum>0) min=sum;
            }
            l++;
        }
        return min==Integer.MAX_VALUE?-1 : min;
    }
}