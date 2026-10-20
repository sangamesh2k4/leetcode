class Solution {
    boolean isRotation(int[] nums,int[] sorted,int start,int k){
      int[] lps=new int[k];
      int len=0;
      for(int i=1;i<k;i++){
        while(len>0 && sorted[start+i]!=sorted[start+len]) len=lps[len-1];
        if(sorted[start+i]==sorted[start+len]) len++;
        lps[i]=len;
      }
      int matched=0;
      for(int i=0;i<2*k-1;i++){
        int value=nums[start+(i%k)];
        while(matched>0 && value!=sorted[start+matched]) matched=lps[matched-1];
        if(value==sorted[start+matched]) matched++;
        if(matched==k) return true;
      }
      return false;
    }
    public int sortableIntegers(int[] nums) {
        int n=nums.length;
        int[] sorted=nums.clone();
        Arrays.sort(sorted);
        int ans=0;
        for(int k=1;k<=n;k++){
            if(n%k!=0) continue;
            boolean sortable=true;
            for(int start=0;start<n;start+=k){
                if(!isRotation(nums,sorted,start,k)){
                    sortable=false;
                    break;
                }
            }
            if(sortable) ans+=k;
        }
        return ans;
    }
}