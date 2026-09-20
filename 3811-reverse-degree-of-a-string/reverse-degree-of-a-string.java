class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=1;i<=s.length();i++){
            char c=s.charAt(i-1);
            int revIndex=('z'-c)+1;
            ans+=i*revIndex;
        }
        return ans;
    }
}