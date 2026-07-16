class Solution {
    List<List<Integer>> ans=new ArrayList<>();
     List<Integer> path=new ArrayList<>();
    void dfs(int node, int graph[][]){
        path.add(node);
        if(node==graph.length-1){
            ans.add(new ArrayList<>(path));
            path.remove(path.size()-1);
            return ;
        }
        for(int neighbor : graph[node]){
            dfs(neighbor,graph);
        }
        path.remove(path.size()-1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        dfs(0,graph);
        return ans;
    }
}