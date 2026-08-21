class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[] flight:flights){
            graph.get(flight[0]).add(new int[]{flight[1],flight[2]});
        }
        int[][] dist=new int[n][k+2];
        for(int[] row : dist){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        dist[src][0]=0;
        pq.offer(new int[] {src,0,0});


        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int node=curr[0];
            int cost=curr[1];
            int flightsUsed=curr[2];
            if(node==dst) return cost;

            for(int[] edge :graph.get(node)){
                int neighbor=edge[0];
                int price=edge[1];
                int newFlights=flightsUsed+1;
                if(newFlights>k+1){
                    continue;
                }
                int newCost=cost+price;
                if(newCost<dist[neighbor][newFlights]){
                    dist[neighbor][newFlights]=newCost;
                pq.offer(new int[] {neighbor,newCost,newFlights});
            }
            }
        }
        return -1;
    }
}