class Solution {
    public double minPrice(int[] prices, int[] discounts) {
        PriorityQueue<Integer> price=new PriorityQueue<>((a, b)->b-a);
        PriorityQueue<Integer> discount=new PriorityQueue<>((a,b)->b-a);
        for(int p:prices){
            price.offer(p);
        }
        for(int d:discounts){
            discount.offer(d);
        }
        double finalprice=0;
        while(!price.isEmpty() && !discount.isEmpty()){
            double p=(double)price.poll();
            double d=(double)discount.poll();
            finalprice+=(p*(100-d))/100;
        }
        while(!price.isEmpty()){
            finalprice+=(double)price.poll();
        }
        return finalprice;
    }
}