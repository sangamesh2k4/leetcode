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
    public boolean equationsPossible(String[] equations) {
        parent=new int[26];
        rank=new int[26];
        for(int i=0;i<26;i++){
            parent[i]=i;
        }
       for(String equation : equations){
        int u=equation.charAt(0)-'a';
        int v=equation.charAt(3)-'a';
        if(equation.charAt(1)=='='){
            union(u,v);
        }
        if(equation.charAt(1)=='!'){
            if(find(u)==find(v)){
                return false;
            }
        }
       }
        for(String equation : equations){
        int u=equation.charAt(0)-'a';
        int v=equation.charAt(3)-'a';
        if(equation.charAt(1)=='!'){
            if(find(u)==find(v)){
                return false;
            }
        }
       }
       return true;
    }
}