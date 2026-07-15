class Solution {

    void bfs(int start,int[][] isConnected, boolean[] visited){
        Queue<Integer> q=new LinkedList<>();
        visited[start]=true;
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int j=0;j<isConnected.length;j++){
                if(isConnected[curr][j]==1 && !visited[j]){
                   visited[j]=true;
                   q.offer(j); 
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int provience=0;
        int n=isConnected.length;
        boolean[] visited=new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                provience++;
                bfs(i,isConnected,visited);
            }
        }
        return provience;
    }
}