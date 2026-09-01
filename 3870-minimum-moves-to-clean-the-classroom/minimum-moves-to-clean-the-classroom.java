class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m=classroom.length;
        int n=classroom[0].length();
        int sr=0,sc=0,litterCount=0;
        int[][] id=new int[m][n];
        for(int i=0;i<m;i++){
            Arrays.fill(id[i],-1);
            for(int j=0;j<n;j++){
                char c=classroom[i].charAt(j);
                if(c=='S'){
                    sr=i;sc=j;
                }
                if(c=='L') id[i][j]=litterCount++;
            }
        }
        if(litterCount==0) return 0;
        int fullmask=(1<<litterCount)-1;
        Queue<int[]> queue=new ArrayDeque<>();
        queue.offer(new int[] {sr,sc,energy,0});
        int[][][] visited=new int[m][n][1 << litterCount];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                Arrays.fill(visited[i][j],-1);
          
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        visited[sr][sc][0]=energy;
        int moves=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-- >0){
            int[] curr=queue.poll();
            int r=curr[0],c=curr[1],e=curr[2],mask=curr[3];
            for(int[] dir:dirs){
                int nr=r+dir[0];
                int nc=c+dir[1];
                if(nr<0 || nr>=m || nc<0 || nc>=n) continue;
                if(classroom[nr].charAt(nc)=='X') continue;
                if(e==0) continue;
                int newEnergy=e-1;
                int newMask=mask;
                char cell=classroom[nr].charAt(nc);
                if(cell=='L') newMask|=(1<< id[nr][nc]);
                if(cell=='R') newEnergy=energy;
                if(newMask==fullmask) return moves+1;
                if(newEnergy> visited[nr][nc][newMask]){
                    visited[nr][nc][newMask]=newEnergy;
                    queue.offer(new int[]{nr,nc,newEnergy,newMask});
                }
            }}
            moves++;
        }

        return -1;
    }
}