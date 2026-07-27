class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj=new ArrayList<>();
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int [] edges : prerequisites){
            int course=edges[0];
            int prerequisite=edges[1];
            adj.get(prerequisite).add(course);
            indegree[course]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
    
    int[] result = new int[numCourses];
    int index = 0;
    while(!q.isEmpty()){
        int node=q.poll();
        result[index++]=node;
        for(int neighbor: adj.get(node)){
            indegree[neighbor]--;
            if(indegree[neighbor]==0){
                q.offer(neighbor);
            }
        }}
        if(index==numCourses){
            return result;
        }
        return new int[0];
    }
}