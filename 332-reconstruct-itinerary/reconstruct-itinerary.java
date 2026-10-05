class Solution {
    Map<String,PriorityQueue<String>> graph=new HashMap<>();
    List<String> answer=new ArrayList<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket :tickets){
            graph.putIfAbsent(ticket.get(0),new PriorityQueue<>());
            graph.get(ticket.get(0)).offer(ticket.get(1));
        }
        dfs("JFK");
        Collections.reverse(answer);
        return answer;
    }
    void dfs(String src){
        while(graph.containsKey(src) && !graph.get(src).isEmpty()){
            String next=graph.get(src).poll();
            dfs(next);
        }
        answer.add(src);

    }
}