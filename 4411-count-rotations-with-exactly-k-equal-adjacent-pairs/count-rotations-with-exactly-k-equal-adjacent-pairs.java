class Solution {
    public int countRotations(String s, int k) {
        int score=0;
        StringBuilder sb=new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char temp=sb.charAt(0);
            sb.deleteCharAt(0);
            sb.append(temp);
            int count=0;
            for(int j=1;j<sb.length();j++){
                if(sb.charAt(j-1)==sb.charAt(j)) count++; 
            }
            if(count==k) score++;
        }
        return score;
    }
}