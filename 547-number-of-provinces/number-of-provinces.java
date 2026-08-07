class Solution {
        int[] parent;
        int[] rank;
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
    public int findCircleNum(int[][] isConnected) { 
        int n=isConnected.length;
        parent=new int[n];
        rank =new int[n];

        int provinces=n;
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(isConnected[i][j]==1){
                    if(find(i)!=find(j)){
                        union(i,j);
                        provinces--;
                    }
                }
            }
        }
        return provinces;
    }
}