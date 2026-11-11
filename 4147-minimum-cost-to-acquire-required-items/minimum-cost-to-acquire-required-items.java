class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long pairs=(long)Math.min(need1,need2);
        long costPairs=pairs*(long)Math.min(costBoth,cost1+cost2);
        long r1=(long)need1-pairs;
        long r2=(long)need2-pairs;
        long costR=r1*(long)Math.min(cost1,costBoth)+r2*(long)Math.min(cost2,costBoth);
        return costPairs+costR;
    }
}