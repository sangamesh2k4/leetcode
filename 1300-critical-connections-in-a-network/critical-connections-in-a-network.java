class Solution {
    int[] disc;
    int[] low;
    int time;
    List<List<Integer>> result;
    void dfs(int u ,int parent ,List<List<Integer>> graph){
        disc[u]=low[u]=++time;

        for(int v: graph.get(u)){
            if(parent==v) continue;
            if(disc[v]==-1){
                dfs(v,u,graph);
            low[u]=Math.min(low[u],low[v]);

            if(low[v]>disc[u]){
                 result.add(Arrays.asList(u,v));
            }
            } else{
                low[u]=Math.min(low[u],disc[v]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(List<Integer> connection  : connections){
            graph.get(connection.get(0)).add(connection.get(1));
            graph.get(connection.get(1)).add(connection.get(0));
        }
         result=new ArrayList<>();
         disc=new int[n];
         low=new int[n];
         Arrays.fill(disc,-1);
         time=0;
        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                dfs(i,-1,graph);
            }
        }
        return result;
    }
}