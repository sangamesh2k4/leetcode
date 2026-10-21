class Solution {
    public int minOperations(String s) {
        int n=s.length();
        boolean sorted=true;
        char mn=s.charAt(0),max=s.charAt(0);
        for(int i=0;i<n;i++){
            char c=s.charAt(i);
            if(i>0 && c<s.charAt(i-1)) sorted=false;
        }
        if(sorted) return 0;
        if(n==2) return -1;
        for(int i=1;i<n;++i){
            char c=s.charAt(i);
            if(c<mn) mn=c;
            if(c>max) max=c;
        }
        if(s.charAt(0)==mn || s.charAt(n-1)==max) return 1;
        for(int i=1;i<n-1;++i){
            char c=s.charAt(i);
            if(c==mn || c==max) return 2;
        }
        return 3;
    }
}