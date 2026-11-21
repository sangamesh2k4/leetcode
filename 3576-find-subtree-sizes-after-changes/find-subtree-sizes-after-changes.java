class Solution {
    void dfs(int node,List<Integer>[] adj,String s,int[] parent,int[] last,List<Integer>[] newTree){
        int ch=s.charAt(node)-'a';
        int prev=last[ch];
        int newPar;
        if(prev!=-1){
            newPar=prev;
        }else{
            newPar=parent[node];
        }if(node!=0)newTree[newPar].add(node);
        last[ch]=node;
        for(int child:adj[node]) dfs(child,adj,s,parent,last,newTree);
        last[ch]=prev;
    }
    int calcSize(int node,List<Integer>[] newTree,int[] ans){
        int size=1;
        for(int child : newTree[node])size+=calcSize(child,newTree,ans);
        ans[node]=size;
        return size;
    }
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n=parent.length;
        List<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++)adj[i]=new ArrayList<>();
        for(int i=1;i<n;i++)adj[parent[i]].add(i);
        List<Integer>[] newTree=new ArrayList[n];
        for(int i=0;i<n;i++)newTree[i]=new ArrayList<>();
        int[] last=new int[26];
        Arrays.fill(last,-1);
        dfs(0,adj,s,parent,last,newTree);
        int[] ans=new int[n];
        calcSize(0,newTree,ans);
        return ans;

    }
}