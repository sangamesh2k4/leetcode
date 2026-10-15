class Solution {
    public int sumCounts(List<Integer> nums) {
        int n=nums.size();
        int ans=0;
        for(int i=0;i<n;i++){
            int count=0;
            boolean[] visited=new boolean[101];
            for(int j=i;j<n;j++){
                if(!visited[nums.get(j)]){
                    count++;
                    visited[nums.get(j)]=true;
                }
                ans+=count*count;
            }
        }
        return ans;
    }
}