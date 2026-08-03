class Solution {
    int answer;
    void dfs(int node,List<List<int[]>> adj,boolean[] visited){
        visited[node]=true;
        for(int[] next : adj.get(node)){
            int neighbor=next[0];
            int cost=next[1];
            if(!visited[neighbor]){
                answer+=cost;
                dfs(neighbor,adj,visited);
            }
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<int[]>> adj=new ArrayList<>();
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge :connections){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(new int[]{v,1});
            adj.get(v).add(new int[]{u,0});
        }
        dfs(0,adj,visited);
       return answer; 
    }
}