class Solution {
    public int minMoves(int[] nums) {
        int mn=Integer.MAX_VALUE;
        long moves=0;
        for(int i : nums) if(i<mn) mn=i;
        for(int i : nums) moves+=i-mn;
        return (int) moves;

    }
}