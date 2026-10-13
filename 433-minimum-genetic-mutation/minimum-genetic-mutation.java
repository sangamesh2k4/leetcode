class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if(startGene.equals(endGene)) return 0;
        int mutations=0;
        boolean found=false;
        for(String s : bank){
            if(s.equals(endGene)){
                found=true;
                break;
            }
        }
        if(!found) return-1;
        Set<String> back=new HashSet<>();
        Set<String> front=new HashSet<>();
        front.add(startGene);
        back.add(endGene);
        char[] options={'A','C','G','T'};
        Set<String> bankSet=new HashSet<>(Arrays.asList(bank));
        while(!front.isEmpty() && !back.isEmpty()){
            if(front.size()>back.size()){
                Set<String> temp=front;
                front=back;
                back=temp;
            }
            Set<String> nextFront=new HashSet<>();
            for(String s : front){
                char[] chars=s.toCharArray();
                for(int i=0;i<chars.length;i++){
                    char org=chars[i];
                    for(char ch :options){
                        if(ch==org) continue;
                        chars[i]=ch;
                        String nextGene=new String(chars);
                        if(back.contains(nextGene)){
                            return mutations+1;
                        }
                        if(bankSet.contains(nextGene)){
                            nextFront.add(nextGene);
                            bankSet.remove(nextGene);
                        }
                    }
                    chars[i]=org;
                }
            }
            front=nextFront;
            mutations++;
        }
        return -1;
    }
}