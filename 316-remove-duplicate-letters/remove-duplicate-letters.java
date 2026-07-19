class Solution {
    public String removeDuplicateLetters(String s) {
        int[] arr=new int[26];
        boolean[] visited=new boolean[26];
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        for(char c : s.toCharArray()){
            arr[c-'a']--;
            if(visited[c-'a']){
                continue;
            }
            while(!st.isEmpty()&& st.peek()>c&& arr[st.peek()-'a']>0){
                visited[st.pop()-'a']=false;
            }
            st.push(c);
            visited[c-'a']=true;
        }
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}