class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Set<Integer> set=new HashSet<>();
        List<Integer> list=new ArrayList<>();
        for(int num :nums){
            if(set.contains(num)) list.add(num);
            else set.add(num);
        }
        return list;
    }
}