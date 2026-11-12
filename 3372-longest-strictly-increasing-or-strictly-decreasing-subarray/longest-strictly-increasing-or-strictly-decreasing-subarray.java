class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=0,dec=0;
        int cinc=1,cdec=1,n=nums.length;
        for(int i=1;i<n;i++){
            if(nums[i]>nums[i-1]){
                cinc++;
                inc=Math.max(cinc,inc);
                cdec=1;            
        }else if(nums[i]<nums[i-1]){
            cdec++;
            dec=Math.max(cdec,dec);
            cinc=1;
        }else{
            cdec=1;
            cinc=1;
        }
        }
        dec=Math.max(cdec,dec);
        inc=Math.max(cinc,inc);
        return Math.max(dec,inc);
    }
}