class Solution {
    int[] parent;
    int[] rank;
    int components,extra;
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }
    void union(int u,int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootV==rootU){
            return;
        }
        if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }
        else if(rank[rootV]>rank[rootU]){
            parent[rootU]=rootV;
        }
        else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }

    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1){
            return -1;
        }
        parent=new int[n];
        rank=new int[n];
        components=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int[] edge :connections){
            if(find(edge[0])!=find(edge[1])){
                union(edge[0],edge[1]);
                components--;
            }
        }
        return components-1;
    }
}