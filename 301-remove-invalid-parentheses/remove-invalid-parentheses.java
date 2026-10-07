class Solution {
    boolean isValid(String s){
        int balance=0;
        for(char c: s.toCharArray()){
            if(c=='('){
                balance++;
            }else if(c==')'){
                balance--;
            }
            if(balance<0) return false;
        }
        return balance==0;
    }
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans=new ArrayList<>();
        Queue<String> queue=new ArrayDeque<>();
        Set<String> visited=new HashSet<>();

        queue.offer(s);
        visited.add(s);
        boolean found=false;
        while(!queue.isEmpty()){
            int size=queue.size();
            for(int i=0;i<size;i++){
                String curr=queue.poll();
                if(isValid(curr)){
                    ans.add(curr);
                    found=true;
                }if(!found){
                for(int j=0;j<curr.length();j++){
                    if(curr.charAt(j)!='(' && curr.charAt(j)!=')') continue;
                    String next=curr.substring(0,j)+curr.substring(j+1);
                    if(!visited.contains(next)){
                        visited.add(next);
                        queue.offer(next);
                    }
                }
             }
            }
            if(found) break;
        }
        return ans;
    }
}