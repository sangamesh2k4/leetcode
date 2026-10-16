class Solution {
    static final long MOD=1_000_000_007L;
    class SegmentTree{
    long[] sum,sumsq,lazy;
    int n;
    SegmentTree(int n){
        this.n=n;
        sum=new long[4*n];
        sumsq=new long[4*n];
        lazy=new long[4*n];
    }
    void apply(int node,int left,int right,long delta){
        long len=right-left+1L;
        sumsq[node]=(sumsq[node]+2L*delta * sum[node]+delta*delta%MOD*len)%MOD;
        sum[node]=(sum[node]+delta*len)%MOD;
        lazy[node]=(lazy[node]+delta)%MOD;
    }
    void push(int node, int left, int right){
        if(lazy[node]==0 || left==right) return;
        int mid=left+(right-left)/2;
        long delta=lazy[node];
        apply(node*2,left,mid,delta);
        apply(node*2+1,mid+1,right,delta);
        lazy[node]=0;
    }
    void update(int node,int left,int right,int ql, int qr){
        if(ql<=left && qr>=right){
        apply(node, left, right,1);
        return;
        }
        push(node, left, right);
        int mid=left+(right-left)/2;
        if(ql<=mid) update(node*2,left,mid,ql,qr);
        if(qr>mid) update(node*2+1,mid+1,right,ql,qr);
        sum[node]=(sum[node*2]+sum[node*2+1])%MOD;
        sumsq[node]=(sumsq[node*2]+sumsq[node*2+1])%MOD;
    }}
    public int sumCounts(int[] nums) {
        int n=nums.length;
        SegmentTree tree=new SegmentTree(n);
        Map<Integer,Integer> last =new HashMap<>();
        long ans=0;
        for(int r=0;r<n;r++){
            int prev=last.getOrDefault(nums[r],-1);
            tree.update(1,0,n-1,prev+1,r);
            ans=(ans+tree.sumsq[1])%MOD;
            last.put(nums[r],r);
        }
        return (int) ans;
    }
}