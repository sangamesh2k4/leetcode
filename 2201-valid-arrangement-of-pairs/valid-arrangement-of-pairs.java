class Solution {
    Map<Integer,List<Integer>> graph=new HashMap<>();
    Map<Integer,Integer> indegree=new HashMap<>();
    Map<Integer,Integer> outdegree=new HashMap<>();
    List<List<Integer>>answer=new ArrayList<>();

    void dfs(int src){
        while(!graph.getOrDefault(src,new ArrayList<>()).isEmpty()){
            int next=graph.get(src).remove(0);
            dfs(next);
            answer.add(Arrays.asList(src,next));
        }
    }

    public int[][] validArrangement(int[][] pairs) {
        for(int[] pair : pairs){
            int from=pair[0],to=pair[1];
            graph.putIfAbsent(from,new ArrayList<>());
            graph.get(from).add(to);
            indegree.put(to,indegree.getOrDefault(to,0)+1);
            outdegree.put(from,outdegree.getOrDefault(from,0)+1);
        }
        int start=pairs[0][0];
        for(int node : outdegree.keySet()){
            if(outdegree.get(node)==indegree.getOrDefault(node,0)+1){
                start=node;
                break;
            }
        }
        dfs(start);
        Collections.reverse(answer);
        return answer.stream()
        .map(list->new int[]{list.get(0),list.get(1)})
        .toArray(int[][]::new);
    }
}