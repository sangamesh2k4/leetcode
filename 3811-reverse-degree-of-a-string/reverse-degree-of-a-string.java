class Solution {
    public int reverseDegree(String s) {
        int ans=0;
        for(int i=1;i<=s.length();i++){
            int revIndex=('z'-s.charAt(i-1))+1;
            ans+=i*revIndex;
        }
        return ans;
    }
}