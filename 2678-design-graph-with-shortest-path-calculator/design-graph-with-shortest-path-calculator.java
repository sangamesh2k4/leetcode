class Graph {
    int[][] dp;
    static final int INF=1_000_000_000;
    public Graph(int n, int[][] edges) {
        dp=new int[n][n];
        for(int i=0;i<n;i++) {
            Arrays.fill(dp[i],INF);
         dp[i][i]=0;
        }
        for(int[] edge :edges){
            dp[edge[0]][edge[1]]=edge[2];
        }
        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    dp[i][j]=Math.min(dp[i][j] ,(dp[i][k]+dp[k][j]));
                }
            }
        }

    }
    
    public void addEdge(int[] edge) {
        dp[edge[0]][edge[1]]=Math.min(dp[edge[0]][edge[1]],edge[2]);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp.length;j++){
                dp[i][j]=Math.min(dp[i][j],(dp[i][edge[0]]+edge[2]+dp[edge[1]][j]));
            }
        }
    }
    
    public int shortestPath(int node1, int node2) {
        return dp[node1][node2]==INF ? -1:dp[node1][node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */