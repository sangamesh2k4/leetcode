class Solution {
    PriorityQueue<Integer> lower=new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Integer> upper=new PriorityQueue<>();
    int smallSize = 0;
    int largeSize = 0;
    Map<Integer,Integer> delayed=new HashMap<>();
    long smallSum,largeSum;

    void add(int num){
        if(lower.isEmpty() || num<=lower.peek()){
            lower.offer(num);
            smallSum+=num;
            smallSize++;
        }else{
            upper.offer(num);
            largeSum+=num;
            largeSize++;
        }
        balance();
    }
    void balance(){
        while(smallSize> largeSize+1){
            prune(lower);

            int x=lower.poll();
            smallSize--;
            smallSum-=x;

            upper.offer(x);
            largeSize++;
            largeSum+=x;
        }
        while(smallSize<largeSize){
            prune(upper);
            int x=upper.poll();
            largeSize--;
            largeSum-=x;

            lower.offer(x);
            smallSize++;
            smallSum+=x;
        }
        prune(lower);
        prune(upper);
    }
    long getCost(){
        prune(lower);
        long median=lower.peek();
        long leftCost=median*smallSize-smallSum;
        long rightCost=largeSum-median*largeSize;
        return leftCost+rightCost;
    }
    void prune(PriorityQueue<Integer> heap){
        while(!heap.isEmpty()){
            int num=heap.peek();
            if(delayed.containsKey(num)){
                heap.poll();
                delayed.put(num,delayed.get(num)-1);
                if(delayed.get(num)==0){
                 delayed.remove(num);
                }}
                else{
                break;
            }
        }
    }
    void remove(int num){
        prune(lower);
        delayed.put(num,delayed.getOrDefault(num,0)+1);
        if(smallSize>0 &&num<=lower.peek()){
            smallSize--;
            smallSum-=num;
        }else{
            largeSize--;
            largeSum-=num;
        }
        if(!lower.isEmpty() && num==lower.peek()){
            prune(lower);
        }else if(!upper.isEmpty() && num==upper.peek()){
            prune(upper);
        }
        balance();
    }
    public long minOperations(int[] nums, int x, int k) {
        int n=nums.length;
        int windows=n-x+1;
        long[] cost=new long[windows];
        for(int i=0;i<x;i++) add(nums[i]);
        cost[0]=getCost();
        for(int i=1;i<windows;i++){
            remove(nums[i-1]);
            add(nums[i+x-1]);
            cost[i]=getCost();
        }
        long INF=Long.MAX_VALUE/4;
        long[][] dp=new long[k+1][n+1];
        for(int t=0;t<=k;t++) Arrays.fill(dp[t],INF);

        for(int i=0;i<=n;i++) dp[0][i]=0;

        for(int t=1;t<=k;t++){
            for(int i=1;i<=n;i++){
                dp[t][i]=dp[t][i-1];
                if(i>=x &&dp[t-1][i-x]!=INF){
                    dp[t][i]=Math.min(dp[t][i],dp[t-1][i-x]+cost[i-x]);
                }
            }
        }
        return dp[k][n];
    }
}