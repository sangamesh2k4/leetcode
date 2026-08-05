class Solution {
    private void dfs(int node, List<List<Integer>> adj, boolean[] suspecious){
        suspecious[node]=true;
        for(int neighbor: adj.get(node)){
            if(!suspecious[neighbor]){
                dfs(neighbor,adj,suspecious);
            }
        }
    }
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge: invocations){
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] suspecious=new boolean[n];
        dfs(k,adj,suspecious);
        List<Integer> list=new ArrayList<>();

        for(int[] edge :invocations){
            if(!suspecious[edge[0]] && suspecious[edge[1]]){
                List<Integer> ans=new ArrayList<>();
                for(int i=0;i<n;i++){
                    ans.add(i);
                }
              return ans;
            }
        }
        for(int i=0;i<suspecious.length;i++){
            if(!suspecious[i]){
                list.add(i);
            }
        }
        return list;
    }
}