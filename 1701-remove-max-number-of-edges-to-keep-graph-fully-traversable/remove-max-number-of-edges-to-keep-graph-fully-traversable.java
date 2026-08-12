class Solution {
    int[] parentAlice;
    int[] rankAlice;
    int[] parentBob;
    int[] rankBob;
    int findAlice(int node){
        if(parentAlice[node]==node){
            return node;
        }
        return parentAlice[node]=findAlice(parentAlice[node]);
    }
    void unionAlice(int u,int v){
        int rootU=findAlice(u);
        int rootV=findAlice(v);
        if(rootU==rootV){
            return;
        }
        if(rankAlice[rootU]>rankAlice[rootV]){
            parentAlice[rootV]=rootU;
        }
        else if(rankAlice[rootV]>rankAlice[rootU]){
            parentAlice[rootU]=rootV;
        }
        else{
            parentAlice[rootV]=rootU;
            rankAlice[rootU]++;
        }
    }
    int findBob(int node){
        if(parentBob[node]==node){
            return node;
        }
        return parentBob[node]=findBob(parentBob[node]);
    }
    void unionBob(int u,int v){
       int  rootU=findBob(u);
        int rootV=findBob(v);
        if(rootU==rootV){
            return;
        }
        if(rankBob[rootU]>rankBob[rootV]){
            parentBob[rootV]=rootU;
        }
        else if(rankBob[rootV]>rankBob[rootU]){
            parentBob[rootU]=rootV;
        }
        else{
            parentBob[rootV]=rootU;
            rankBob[rootU]++;
        }
    }
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        parentAlice=new int[n+1];
        parentBob=new int[n+1];
        for(int i=1;i<=n;i++){
            parentAlice[i]=i;
            parentBob[i]=i;
        }
        rankBob=new int[n+1];
        rankAlice=new int[n+1];
        int removed=0;
        int AliceComponents=n;
        int BobComponents=n;
        for(int[] edge:edges){
            int u=edge[1];
            int v=edge[2];
            if(edge[0]==3){
                boolean aliceNeeds=findAlice(u)!=findAlice(v);
                boolean bobNeeds=findBob(u)!=findBob(v);
                if(aliceNeeds){
                    unionAlice(u,v);
                    AliceComponents--;
                }
                if(bobNeeds){
                    unionBob(u,v);
                    BobComponents--;
                }
                if(!bobNeeds && !aliceNeeds){
                    removed++;
                }
            }}
             for(int[] edge:edges){
            int u=edge[1];
            int v=edge[2];
            if(edge[0]==1){
                boolean aliceNeeds=findAlice(u)!=findAlice(v);
                if(!aliceNeeds){
                    removed++;
                }
                else{
                    unionAlice(u,v);
                    AliceComponents--;
                }
            }}
             for(int[] edge:edges){
            int u=edge[1];
            int v=edge[2];
            if(edge[0]==2){
                 boolean bobNeeds=findBob(u)!=findBob(v);
                if(!bobNeeds){
                    removed++;
                }
                else{
                    unionBob(u,v);
                    BobComponents--;
                }
            }
        }
        if(AliceComponents != 1 || BobComponents!=1) return -1;
        return removed;
    }
}