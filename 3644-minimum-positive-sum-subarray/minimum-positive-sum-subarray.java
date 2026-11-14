class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int m=Integer.MAX_VALUE;
        while(l<=r){
            int s=0;
            for(int i=0;i<l;i++) s+=nums.get(i);
            if(s<m && s>0) m=s;
            for(int i=l;i<nums.size();i++){
                s-=nums.get(i-l);
                s+=nums.get(i);
                if(s<m && s>0) m=s;
            }
            l++;
        }
        return m==Integer.MAX_VALUE?-1 : m;
    }
}