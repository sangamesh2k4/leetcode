class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> visited=new HashSet<>();
        Queue<String> queue=new LinkedList<>();
        queue.offer("0000");
        visited.add("0000");
        Set<String> dead = new HashSet<>();
        for(String s : deadends){
             dead.add(s);
             }
             if(dead.contains("0000")){
                return -1;
                }
        int moves=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-- > 0){
                String curr=queue.poll();
                if(curr.equals(target)){
                    return moves;
                }
                for(int i=0;i<4;i++){
                    int digit=curr.charAt(i)-'0';
                    int next=(digit+1)%10;
                    int prev=(digit+9)%10;
                    char[] chars=curr.toCharArray();
                    chars[i]=(char)('0'+next);
                    String nextState=new String(chars);
                      if(!dead.contains(nextState) && !visited.contains(nextState)){
        queue.offer(nextState);
        visited.add(nextState);
    }

                    chars=curr.toCharArray();
                    chars[i]=(char)('0'+prev);
                    String prevState=new String(chars);
                    if(!dead.contains(prevState) && !visited.contains(prevState)){
        queue.offer(prevState);
        visited.add(prevState);
    }
                }
            }
            moves++;
        }
        return -1;
    }
}