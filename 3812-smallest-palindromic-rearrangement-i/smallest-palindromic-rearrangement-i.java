class Solution {
    public String smallestPalindrome(String s) {
        StringBuilder sb=new StringBuilder();
        char middle=0;
        int[] arr=new int[26];
        for(char c: s.toCharArray()){
            arr[c-'a']++;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i]/2;j++){
            sb.append((char)(i+'a'));
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==1){
                middle=(char)(i+'a');
            }
        }
        StringBuilder ans=new StringBuilder(sb);
        if(middle!=0){
            ans.append(middle);
        }
        ans.append(sb.reverse());
        return ans.toString();
    }

}