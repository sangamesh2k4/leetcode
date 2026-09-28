class Solution {
    public int maxDepth(String s) {
       int count=0;
       int res=0;
       for(char c: s.toCharArray()){
        if(c=='('){
            count++;
        }else if(c==')') {
            res=Math.max(res,count);
            count--;
       } }
       return res;
    }
}