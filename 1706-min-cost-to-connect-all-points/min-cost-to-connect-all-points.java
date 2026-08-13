class Solution {
    int[] parent,rank;
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }
    void union(int u,int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootU==rootV){
            return;
        }
        if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }
        else if(rank[rootV]>rank[rootU]){
            parent[rootU]=rootV;
        }
        else {
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        List<int[]> edges=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=Math.abs(points[i][0]-points[j][0])
                +Math.abs(points[i][1]-points[j][1]);
                edges.add(new int[]{i,j,cost});
            }
        }
        parent=new int[n];
        rank=new int[n];
        edges.sort((a,b)-> a[2]-b[2]);
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        int cost=0,count=0;
        for(int[] edge : edges){
            if(find(edge[0])==find(edge[1])){
                continue;
            }
            union(edge[0],edge[1]);
            cost+=edge[2];
            count++;
            if(count==n-1){
                break;
            }
        }
        return cost;
    }
}