class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        backtrack("",0,0,n,ans);
        return ans;
    }
    void backtrack(String current,int open,int close,int n,List<String> ans){
        if(open==n && close==n) {
            ans.add(current);
            return;
        }
        if(open<n){
            backtrack(current+"(",open+1,close,n,ans);
        }
        if(close<open){
            backtrack(current+")",open,close+1,n,ans);
        }
    }
}