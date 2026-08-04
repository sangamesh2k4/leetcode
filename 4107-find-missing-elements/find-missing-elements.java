class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int num:nums){
            if(num>max){
                max=num;
            }
            if(num<min){
                min=num;
            }
        }
        boolean[] arr=new boolean[max+1];
         List<Integer> list=new ArrayList<>();
       for( int num:nums){
        arr[num]=true;
       }
        for( int i=min;i<=max;i++){
            if(arr[i]!=true){
                list.add(i);
           }
        }


        return list;
    }
}