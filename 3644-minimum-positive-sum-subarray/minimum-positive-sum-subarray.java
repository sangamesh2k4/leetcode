class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int minsum=999999999;
        while(l<=r){
            int sum=0;
            for(int i=0;i<l;i++){
                sum+=nums.get(i);
            }
            if(sum>0 && sum<minsum){
                minsum=sum;
            }
            for(int i=l;i<nums.size();i++){
                sum=sum-nums.get(i-l);
                sum=sum+nums.get(i);
                if(sum<minsum && sum>0){
                    minsum=sum;
                }
            }
            l++;
        }
        if(minsum==999999999){
            return -1;
        }
        return minsum;
    }
}
