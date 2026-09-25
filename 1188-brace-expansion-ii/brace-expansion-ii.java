class Solution {
    String s;
    int pos;
    public List<String> braceExpansionII(String expression) {
        s=expression;
        pos=0;
        Set<String> result=parseExpression();
        List<String> ans=new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }
    Set<String> parseExpression(){
        Set<String> result=parseTerm();
        while(pos<s.length() && s.charAt(pos)==','){
            pos++;
            Set<String> next=parseTerm();
            result.addAll(next);
        }
        return result;
    }
    Set<String> parseTerm(){
        Set<String> result=new HashSet<>();
        result.add("");
        while(pos<s.length() && s.charAt(pos)!=',' && s.charAt(pos)!='}'){
            Set<String> factor=parseFactor();
            result=concat(result,factor);
        }
        return result;
    }
    Set<String> parseFactor(){
        Set<String> result=new HashSet<>();
        if(s.charAt(pos)=='{'){
            pos++;
            result=parseExpression();
            pos++;
        }else{
            result.add(String.valueOf(s.charAt(pos)));
            pos++;
        }
        return result;
    }
    Set<String> concat(Set<String> a, Set<String> b){
        Set<String> result=new HashSet<>();
        for(String x:a){
            for(String y:b){
                result.add(x+y);
            }
        }
        return result;
    }
}