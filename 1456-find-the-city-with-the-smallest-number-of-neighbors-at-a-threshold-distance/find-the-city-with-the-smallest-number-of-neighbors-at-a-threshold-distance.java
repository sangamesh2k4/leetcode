class Solution {
    private int djisktra(int node,List<List<int[]>> graph,int threshold){
     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
    int[] dist=new int[graph.size()];
    Arrays.fill(dist,Integer.MAX_VALUE);
     dist[node]=0;
     pq.offer(new int[] {node,0});
     int count=0;
     while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int currNode=curr[0];
        int currDist=curr[1];
        if(currDist>dist[currNode]) continue;
        if(currNode !=node) count++;
        for(int[] edge : graph.get(currNode)){
            int neighbor=edge[0];
            int weight=edge[1];
            int newDist=currDist+weight;
            if(newDist<=threshold && newDist<dist[neighbor]){
                dist[neighbor]=newDist;
                pq.offer(new int[] {neighbor,newDist});
            }
        }
     }
     return count;

    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge:edges){
            graph.get(edge[0]).add(new int[]{edge[1],edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }

        int ans=-1;
        int best=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int currCount=djisktra(i,graph,distanceThreshold);
            if(currCount<=best){
                best=currCount;
                ans=i;
            }
        }
        return ans;
    }
}