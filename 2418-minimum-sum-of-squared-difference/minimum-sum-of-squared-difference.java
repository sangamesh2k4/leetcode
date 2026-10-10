class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        long k=(long) k1+k2;
        int n=nums1.length;
        long[] diff=new long[n];
        long max=0;
        long sum=0;
        for(int i=0;i<n;i++){
            diff[i]=Math.abs(nums1[i]-nums2[i]);
            max=Math.max(max,diff[i]);
            sum+=diff[i];
        }
        if(k>=sum) return 0;
        long left=0,right=max;

        while(left<right){
            long mid=left+(right-left)/2;
            long op=0;
            for(long d :diff){
                if(d>mid) op+=d-mid;
            }
            if(op<=k) right=mid;
            else left=mid+1;
        }
        long remainingOps = k;

for (int i = 0; i < n; i++) {
    if (diff[i] > left) {
        remainingOps -= diff[i] - left;
        diff[i] = left;
    }
}

for (int i = 0; i < n && remainingOps > 0; i++) {
    if (diff[i] == left && diff[i] > 0) {
        diff[i]--;
        remainingOps--;
    }
}

long ans = 0;
for (long d : diff) {
    ans += d * d;
}
return ans;
    }
}