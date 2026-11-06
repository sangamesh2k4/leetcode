class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        Arrays.sort(logs,(a,b)->Integer.compare(a[1],b[1]));
        int q=queries.length;
        Integer[] order=new Integer[q];
        for(int i=0;i<q;i++) order[i]=i;
        Arrays.sort(order,(a,b)->Integer.compare(queries[a],queries[b]));
        Map<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[q];
        int left=0,right=0;
        for(int idx : order){
            int time=queries[idx];
            while(right<logs.length && logs[right][1]<=time){
                int server=logs[right][0];
                map.put(server,map.getOrDefault(server,0)+1);
                right++;
            }
            while(left<right && logs[left][1]<time-x){
                int server=logs[left][0];
                map.put(server,map.get(server)-1);
                if(map.get(server)==0) map.remove(server);
                left++;
            }
            ans[idx]=n-map.size();
        } 
        return ans;
    }
}