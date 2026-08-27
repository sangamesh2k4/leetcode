class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
     List<List<Integer>> graph=new ArrayList<>();
     for(int i=0;i<=n;i++){
        graph.add(new ArrayList<>());
     }
     for(int[] edge:edges){
        graph.get(edge[0]).add(edge[1]);
        graph.get(edge[1]).add(edge[0]);
     }
     int[] first=new int[n+1];
     int[] second=new int[n+1];
     Arrays.fill(first,Integer.MAX_VALUE);
     Arrays.fill(second,Integer.MAX_VALUE);
     first[1]=0;
     PriorityQueue<int[]> pq=new PriorityQueue<>((a,b)-> a[1]-b[1]);
     pq.offer(new int[] {1,0});
     while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int node=curr[0];
        int currtime=curr[1];
        if(node==n && currtime>first[n]) return currtime;
        if(currtime/change %2==1){
            currtime+=change-currtime%change;
        }
        int newtime=currtime+time;
        for(int neighbor: graph.get(node)){
        if(newtime<first[neighbor]){
            second[neighbor]=first[neighbor];
            first[neighbor]=newtime;
            pq.offer(new int[] {neighbor ,newtime});
        } else if(newtime>first[neighbor] && newtime<second[neighbor]){
            second[neighbor]=newtime;pq.offer(new int[] {neighbor,newtime});
        } }
     }
     return second[n];
    }
}