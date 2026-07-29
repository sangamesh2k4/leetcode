class Solution {
    void dfs(int room,boolean[] visited,List<List<Integer>> rooms){
        visited[room]=true;
        for(int nextroom : rooms.get(room)){
            if(!visited[nextroom]){
                dfs(nextroom,visited,rooms);
            }
        }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited=new boolean[rooms.size()];
        dfs(0,visited,rooms);
        for(boolean roomvisited: visited){
            if(!roomvisited){
                return false;
            }
        }
        return true;
    }
}