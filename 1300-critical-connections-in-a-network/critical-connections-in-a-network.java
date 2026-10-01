class Solution {
    int[] disc,low;
    int time;
    List<List<Integer>> result;
    boolean[] isArticulation;
    public void dfs(List<List<Integer>> graph,int u,int parent){
        disc[u]=low[u]=++time;

        for(int neighbor : graph.get(u)){
            if(neighbor==parent){
                continue;
            }
            else if(disc[neighbor]==-1){
                dfs(graph,neighbor,u);
                low[u]=Math.min(low[u],low[neighbor]);
                if(low[neighbor]>disc[u]){
                   result.add(Arrays.asList(u,neighbor));
                }
            }else{
                low[u]=Math.min(low[u],disc[neighbor]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        disc=new int[n];
        low=new int[n];
        isArticulation=new boolean[n];
        time=0;
        result=new ArrayList<>();
        List<List<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        Arrays.fill(disc,-1);
        for(List<Integer> connection : connections){
            graph.get(connection.get(0)).add((connection.get(1)));
            graph.get(connection.get(1)).add((connection.get(0)));
        }
        for(int i=0;i<n;i++){
            if(disc[i]==-1){
                dfs(graph,i,-1);
            }
        }
        return result;
    }
}