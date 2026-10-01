class Solution {
    public boolean isValid(String s) {
        if(s.charAt(0)=='}'|| s.charAt(0)==']' || s.charAt(0)==')') return false;
        Stack<Character> stack=new Stack<>();
        for(char c : s.toCharArray()){
            if(c=='(' || c=='[' || c=='{'){
                stack.push(c);
            } else{
                if(stack.isEmpty()){
                    return false;
                }else if(c==']'&& stack.peek()=='[' || c=='}' && stack.peek()=='{' || c==')' && stack.peek()=='('){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}