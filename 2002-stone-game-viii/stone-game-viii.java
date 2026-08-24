class Solution {
    public int stoneGameVIII(int[] stones) {
       int[] prefix=new int[stones.length];
       prefix[0]=stones[0];
       for(int i=1;i<stones.length;i++){
        prefix[i]=prefix[i-1]+stones[i];
       } 
       int best=prefix[prefix.length-1];
       for(int i=prefix.length-2;i>=1;i--){
        best=Math.max(best,prefix[i]-best);
       }
       return best;
    }
}