class Solution {
    public List<List<String>> findMismatchedSegments(String s1, String s2) {
        List<List<String>> list=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        StringBuilder sb2=new StringBuilder();
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)==s2.charAt(i) && !sb.isEmpty()){
                List<String> res=new ArrayList<>();
                res.add(sb.toString());
                res.add(sb2.toString());
                list.add(res);
                sb.setLength(0);
                sb2.setLength(0);
            }
            else if(s1.charAt(i)!=s2.charAt(i)){
                sb.append(s1.charAt(i));
                sb2.append(s2.charAt(i));
            }
        }
        if(!sb.isEmpty()){
                List<String> res=new ArrayList<>();
                res.add(sb.toString());
                res.add(sb2.toString());
                list.add(res);
                sb.setLength(0);
                sb2.setLength(0);
            }
        return list;
    }
}