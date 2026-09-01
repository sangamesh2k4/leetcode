class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        for(int i=1;i<=n-1;i++){
            for(int[] time :times){
                int from=time[0],to=time[1],weight=time[2];
                if(dist[from]!=Integer.MAX_VALUE && dist[from]+weight<dist[to])
                 dist[to]=dist[from]+weight;
            }
        }
        int ans=0;
        for(int i=1;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE) return -1;
            ans=Math.max(ans,dist[i]);
        }
        return ans;
    }
}