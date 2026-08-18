class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> queue=new LinkedList<>();
        HashSet<String> visited=new HashSet<>();
        Set<String> words = new HashSet<>(wordList);
        queue.offer(beginWord);
        visited.add(beginWord);
        int dist=1;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-- >0){
                String word=queue.poll();
                if(word.equals(endWord)){
                    return dist;
                }
                for(int i=0;i<word.length();i++){
                    for(char c='a';c<='z';c++){
                        if(c==word.charAt(i)) continue;
                        char[] chars=word.toCharArray();
                        chars[i]=c;
                        String nextWord=new String(chars);
                        if(words.contains(nextWord) && !visited.contains(nextWord)){
                            queue.offer(nextWord);
                            visited.add(nextWord);
                        }
                    }
                }
            }
            dist++;
        }
        return 0;
    }
}