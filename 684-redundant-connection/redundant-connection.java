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
        else{
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n=edges.length;
        parent=new int[n+1];
        rank=new int[n+1];
        for(int i=0;i<parent.length;i++){
            parent[i]=i;
        }
        for(int[] edge :edges){
            if(find(edge[0])==find(edge[1])){
                return edge;
            }
            union(edge[0],edge[1]);
        }
        return new int[0];
    }

}