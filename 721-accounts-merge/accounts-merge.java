class Solution {
    int[] parent,rank;
    int find(int node){
        if(parent[node]==node){
            return node;
        }
        return parent[node]=find(parent[node]);
    }
    void union(int u,int v){
        int rootU=find(u);
        int rootV=find(v);
        if(rootU==rootV){
            return;
        }
        if(rank[rootU]>rank[rootV]){
            parent[rootV]=rootU;
        }
        else if(rank[rootV]>rank[rootU]){
            parent[rootU]=rootV;
        }
        else {
            parent[rootV]=rootU;
            rank[rootU]++;
        }
    }
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String,Integer> emailToId=new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int index=0;
        for(List<String> account: accounts){
            for(int j=1;j<account.size();j++){
                String email=account.get(j);
                if(!emailToId.containsKey(email)){
                    emailToId.put(email,index);
                    emailToName.put(email, account.get(0));
                    index++;
                }
            }
        }
        parent=new int[index];
        rank=new int[index];
        for(int i=0;i<index;i++){
            parent[i]=i;
        }
        for(List<String> account:accounts){
            int first=emailToId.get(account.get(1));
            for(int j=2;j<account.size();j++){
                int curr=emailToId.get(account.get(j));
                union(first,curr);
            }
        }
        Map<Integer,List<String>> groups=new HashMap<>();
        for(Map.Entry<String,Integer> entry : emailToId.entrySet()){
            String email=entry.getKey();
            int id=entry.getValue();
            int root=find(id);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(email);
        }
        List<List<String>> result = new ArrayList<>();
        for(List<String>emails :groups.values()){
            Collections.sort(emails);
            List<String> account=new ArrayList<>();
            account.add(emailToName.get(emails.get(0)));
            account.addAll(emails);
            result.add(account);
        }
        return result;
    }
}