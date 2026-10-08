class Solution {
    public String removeOuterParentheses(String s) {
        int count=0;
        StringBuilder s1=new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(count>0){
                    s1.append('(');
                }
                    count++;
                
            }
            else{
                count--;
                if(count>0){
                    s1.append(')');
                }
            }
        }
        return s1.toString();
    }
}