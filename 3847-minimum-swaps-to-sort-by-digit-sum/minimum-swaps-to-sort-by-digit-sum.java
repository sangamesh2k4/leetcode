class Solution {
    int digitSum(int num){
        int sum=0;
        while(num>0){
            sum+=num%10;
            num/=10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        int n=nums.length;
        Integer[] idx=new Integer[n];
        for(int i=0;i<n;i++) idx[i]=i;
        Arrays.sort(idx,(a,b)->{
            int sumA=digitSum(nums[a]);
            int sumB=digitSum(nums[b]);
            if(sumA!=sumB) return Integer.compare(sumA,sumB);
            return Integer.compare(nums[a],nums[b]);
        });
        boolean[] visited=new boolean[n];
        int swaps=0;
        for(int i=0;i<n;i++){
            if(visited[i] || idx[i]==i) continue;
            int cycleLength=0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=idx[j];
                cycleLength++;
            }
            swaps+=cycleLength-1;
        }
       return swaps; 
    }
}