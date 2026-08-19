class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        PriorityQueue<double[]> pq=new PriorityQueue<>((a,b)-> Double.compare(b[1],a[1]));
        double[] prob=new double[n];
        prob[start_node]=1.0;
        pq.offer(new double[]{start_node,1.0});
        List<List<double[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
      for(int i=0;i<edges.length;i++){
        graph.get(edges[i][0]).add(new double[]{edges[i][1],succProb[i]});
        graph.get(edges[i][1]).add(new double[]{edges[i][0],succProb[i]});
      }
      while(!pq.isEmpty()){
        double[] curr=pq.poll();
        int node =(int) curr[0];
        double currProb=curr[1];
        for(double[] edge :graph.get(node)){
            int neighbor=(int)edge[0];
            double edgeProb=edge[1];
            double newProb=currProb*edgeProb;
            if(newProb>prob[neighbor]){
                prob[neighbor]=newProb;
                pq.offer(new double[] {neighbor,newProb});
            }
        }
      }
      return prob[end_node];
    }
}