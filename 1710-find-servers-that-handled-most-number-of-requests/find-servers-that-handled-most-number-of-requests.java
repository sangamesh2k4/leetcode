class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
       TreeSet<Integer> available=new TreeSet<>();
       PriorityQueue<int[]> busy=new PriorityQueue<>((a,b)->Integer.compare(a[0],b[0]));
       int[] count= new int[k];
       for(int i=0;i<k;i++) available.add(i);
       int maxRequests=0;
       for(int i=0;i<arrival.length;i++){
       while(!busy.isEmpty() && busy.peek()[0]<=arrival[i]){
        int[] server=busy.poll();
        available.add(server[1]);
       }
       if(available.isEmpty()) continue;
       int preferred=i%k;
       Integer server=available.ceiling(preferred);
       if(server==null) server=available.first();
       available.remove(server);
       count[server]++;
       maxRequests=Math.max(maxRequests,count[server]);
       busy.offer(new int[]{arrival[i]+load[i],server});
       }
       List<Integer> list=new ArrayList<>();
       for(int i=0;i<k;i++){
        if(count[i]==maxRequests) list.add(i);
       }
       return list;
    }
}