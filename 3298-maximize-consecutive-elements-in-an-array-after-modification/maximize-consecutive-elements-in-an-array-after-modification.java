class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        int b=1,k=1,bu=1,l=-10;
        for(int i :nums){
            switch(i-l){
                case 0 -> bu=k+1;
                case 1 ->{
                    k++;bu++;
                }
                case 2 ->{
                    k=bu+1;
                    bu=1;
                }
                default -> k=bu=1;
            }
            b=Math.max(b,Math.max(k,bu));
            l=i;
        }
        return b;
    }
}