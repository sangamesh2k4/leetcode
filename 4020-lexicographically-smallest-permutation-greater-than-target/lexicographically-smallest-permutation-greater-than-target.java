class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int[] freq=new int[26];
        for(char c :s.toCharArray()){
            freq[c-'a']++;
        }
        for(char c :target.toCharArray()){
            freq[c-'a']--;
        }
        for(int i=target.length()-1;i>=0;i--){
            int curr=target.charAt(i)-'a';
            freq[curr]++;
        
        boolean ok=true;
        for(int x:freq){
            if(x<0){
                ok=false;
                break;
            }
        }
        if(!ok) continue;
        int next=-1;
        for(int c=curr+1;c<26;c++){
            if(freq[c]>0){
                next=c; break;
            }
        }
        if(next==-1) continue;
        freq[next]--;
        StringBuilder ans=new StringBuilder(target.substring(0,i));
        ans.append((char)('a'+next));
        for(int c=0;c<26;c++){
            while(freq[c]-->0){
                ans.append((char)('a'+c));
            }
        }
        return ans.toString();
    }
    return "";
    }
}