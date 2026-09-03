class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        boolean[][] dp=new boolean[numCourses][numCourses];
        for(int[] prerequisite :prerequisites){
            dp[prerequisite[0]][prerequisite[1]]=true;
        }
        for(int k=0;k<numCourses;k++){
            for(int i=0;i<numCourses;i++){
                for(int j=0;j<numCourses;j++){
                    dp[i][j]=dp[i][j]|| (dp[i][k]&& dp[k][j]);
                }
            }
        }
        List<Boolean> ans=new ArrayList<>();
        for(int[] query : queries){
            ans.add(dp[query[0]][query[1]]);
        }
        return ans;
    }
}