class Solution {
    private boolean buildLeftHalf(int currPos,boolean alreadyGreaterThanTarget,String target,int[] charFreq,
    char[] leftHalf,char middleCharacter,int StringLength){
        if(currPos==leftHalf.length) {
            String leftPart=new String(leftHalf);
            String rightPart=new StringBuilder(leftPart).reverse().toString();
            String palindrome=leftPart;
            if(StringLength%2==1) palindrome+=middleCharacter;
            palindrome+=rightPart;
            return palindrome.compareTo(target)>0;
        }
        char firstCharToTry;
        if(alreadyGreaterThanTarget){
            firstCharToTry='a';
        }
        else{
            firstCharToTry=target.charAt(currPos);
        }
        for(char currentCharacter=firstCharToTry;currentCharacter<='z';currentCharacter++){
            int characterIndex=currentCharacter-'a';
            if(charFreq[characterIndex]==0) continue;
            leftHalf[currPos]=currentCharacter;
            charFreq[characterIndex]--;
            boolean nowGreaterThanTarget=alreadyGreaterThanTarget|| currentCharacter>target.charAt(currPos);
            if(buildLeftHalf(currPos+1,nowGreaterThanTarget,target,charFreq,leftHalf,middleCharacter,StringLength)) return true;
            charFreq[characterIndex]++;
        }
        return false;
    }
    public String lexPalindromicPermutation(String s, String target) {
        int[] freq=new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        int oddFreqCount=0;
        char midChar=0;
        for(int i=0;i<26;i++){
            if(freq[i]%2==1){
                oddFreqCount++;
                midChar=(char)('a'+i);
            }
        }
        if(oddFreqCount>1) return "";
        for(int i=0;i<26;i++){
            freq[i]/=2;
        }
        int n=s.length();
        int halfLength=n/2;
        char[] leftHalf=new char[halfLength];
        if(buildLeftHalf(0,false,target,freq,leftHalf,midChar,n)){
            String leftPart=new String(leftHalf);
            String rightPart=new StringBuilder(leftPart).reverse().toString();
            String palindrome=leftPart;
            if(n%2==1) palindrome+=midChar;
            palindrome+=rightPart;
            return palindrome;
        }
        return "";
    }
}