class Solution {

    boolean dfs(int node,List<List<Integer>> adj,int[] color){
        for(int neighbor : adj.get(node)){
            if(color[neighbor]==0){
                color[neighbor]=-color[node];
                if(!dfs(neighbor,adj,color)) return false;
            }
            else if(color[neighbor]==color[node]){
                return false;
            }
        }
        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] dislike: dislikes){
            int u=dislike[0];
            int v=dislike[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] color = new int[n + 1];
        for(int i=1;i<=n;i++){
            if(color[i]==0){
                color[i]=1;
                if(!dfs(i,adj,color)){
                    return false;
                }
            }
        }
        return true;
    }
}