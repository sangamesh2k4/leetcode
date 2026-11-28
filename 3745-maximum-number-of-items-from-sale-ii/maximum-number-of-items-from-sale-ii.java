class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n=items.length,maxFactor=0;
        long minPrice=Long.MAX_VALUE;
        for(int[] item :items){
            maxFactor=Math.max(maxFactor,item[0]);
            minPrice=Math.min(minPrice,item[1]);
        }
        int[] freq=new int[maxFactor+1];
        for(int[] item :items) freq[item[0]]++;
        int[] mult=new int[maxFactor+1];
        for(int d=1;d<=maxFactor;d++){
            for(int j=d;j<=maxFactor;j+=d) mult[d]+=freq[j];
        }
        Arrays.sort(items,(a,b)->Integer.compare(a[1],b[1]));
        long remaining=budget,ans=0;
        for(int[] item :items){
            int factor=item[0];
            int price=item[1];
            if(2L*minPrice<=price) break;
            int gain=mult[factor]-1;
            if(gain==0) continue;
            long take=Math.min((long)gain,remaining/price);
            ans+=take*2;
            remaining-=take*price;
        }
        ans+=remaining/minPrice;
        return (int)ans;
    }
}