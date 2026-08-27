class Solution {
    public int countPaths(int n, int[][] roads) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] road:roads){
            graph.get(road[0]).add(new int[]{road[1],road[2]});
            graph.get(road[1]).add(new int[]{road[0],road[2]});
        }
        long[] ways=new long[n];
        long[] dist=new long[n];
        ways[0]=1;dist[0]=0;
        Arrays.fill(dist,Long.MAX_VALUE);
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b) -> Long.compare(a[1],b[1]));
        pq.offer(new long[]{0,0});
        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            int node=(int)curr[0];
            long time=curr[1];
            for(int[] edge:graph.get(node)){
                int neighbor=edge[0];
                int traveltime=edge[1];
                long newtime=traveltime+time;
                if(newtime<dist[neighbor]){
                    dist[neighbor]=newtime;
                    ways[neighbor]=ways[node];
                    pq.offer(new long[]{neighbor,newtime});
                }
                else if(newtime==dist[neighbor]){
                    ways[neighbor]=(ways[neighbor]+ways[node])%1_000_000_007;
                }
            }
        }
        return (int) ways[n-1];
    }
}