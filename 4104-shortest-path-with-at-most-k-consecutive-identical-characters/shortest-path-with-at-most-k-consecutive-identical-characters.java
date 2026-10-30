class State{
    int node;
    int count;
    int distance;
    State(int node,int count,int distance){
        this.distance=distance;
        this.count=count;
        this.node=node;
    }

}
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        PriorityQueue<State> pq=new PriorityQueue<>(
            (a,b)-> Integer.compare(a.distance,b.distance)
            );
            List<int[]>[] graph=new ArrayList[n];
            for(int i=0;i<n;i++) graph[i]=new ArrayList<>();
            for(int [] edge :edges) graph[edge[0]].add(new int[]{edge[1],edge[2]});

            int[][] dist=new int[n][k+1];
            for(int[] d :dist){
                Arrays.fill(d,Integer.MAX_VALUE);
            }
            dist[0][1]=0;
            pq.offer(new State(0,1,0));
            while(!pq.isEmpty()){
                State curr=pq.poll();
                int u= curr.node;
                int count=curr.count;
                int distance=curr.distance;
                if(distance!=dist[u][count]) continue;
                for(int[] edge : graph[u]){
                    int v=edge[0];
                    int weight=edge[1];
                    int nextCount=(labels.charAt(u)==labels.charAt(v))? count +1 :1;
                    if(nextCount>k) continue;
                    int newDist=distance+weight;
                    if(newDist<dist[v][nextCount]){
                        dist[v][nextCount]=newDist;
                        pq.offer(new State(v,nextCount,newDist));
                    }
                }
            }
            int ans=Integer.MAX_VALUE;
            for(int i=0;i<=k;i++) ans=Math.min(ans,dist[n-1][i]);
            return ans==Integer.MAX_VALUE ? -1 : ans;
    }
}