class Solution {
    int[] parent;
    int[] rank;
    private int find(int x){
        if(parent[x]==x) return x;
       return  parent[x]=find(parent[x]);
    }
    private void union(int a,int b){
        int rootA=find(a);
        int rootB=find(b);
        if(rootA==rootB) {
            return;
        }else if(rank[rootA]>rank[rootB]){
            parent[rootB]=rootA;
        }else if(rank[rootB]>rank[rootA]){
            parent[rootA]=rootB;
        }
        else{
            parent[rootB]=rootA;
            rank[rootA]++;
        }
    }
    private boolean canAchieve(int n,int[][] edges,int k,int x){
        parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
        }
        rank=new int[n];
        int components=n;
        int upgrades=0;
        for(int[] edge :edges){
            if(edge[3]==1){
            if(edge[2]<x) return false;
            if( find(edge[0])==find(edge[1])) return false;
                union(edge[0],edge[1]);
                components--;
                 }
        }
        for(int[] edge :edges){
            if(edge[3]==0 && edge[2]>=x && find(edge[0])!=find(edge[1])){
                union(edge[0],edge[1]);
                components--;
            }
        }
        for(int[] edge :edges){
            if(edge[3]==0 && edge[2]<x && 2*edge[2]>=x && upgrades <k && find(edge[1])!=find(edge[0])){
                union(edge[0],edge[1]);
                components--;
                upgrades++;
            }
        }
        return components==1;
    }
    public int maxStability(int n, int[][] edges, int k) {

        int low=0;
        int maxStrength=0;
        int minMust=Integer.MAX_VALUE;
        boolean hasMust=false;

        for(int []edge :edges){
            maxStrength=Math.max(edge[2],maxStrength);
            if(edge[3]==1){
                hasMust=true;
                minMust=Math.min(minMust,edge[2]);
            }
        }
        int high;
        if(hasMust){
            high=minMust;
        }else{
            high=2*maxStrength;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(canAchieve(n,edges,k,mid)){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return high;

    }
}