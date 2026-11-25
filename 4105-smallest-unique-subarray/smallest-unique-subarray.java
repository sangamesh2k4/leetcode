class Solution {
    static long[] rollingHash(long hash,long hash2,int outgoing,int incoming
    ,long power1,long power2){
        long mod1=1_000_000_007;
        long mod2=1_000_000_009;
        long base1=31;
        long base2=37;

        long hash1=(hash - outgoing * power1%mod1+mod1)%mod1;
        hash1=(hash1*base1+incoming)%mod1;


        hash2=(hash2 - outgoing * power2%mod2+mod2)%mod2;
        hash2=(hash2*base2+incoming)%mod2;
        return new long[]{hash1,hash2};
    }
    boolean isValid(int k,int[] nums){
        long base1=31,mod1=1_000_000_007;
        long base2=37,mod2=1_000_000_009;
        HashMap<String,Integer> map=new HashMap<>();
        long highestPower1=1;
        long highestPower2=1;
        for(int i=1;i<k;i++){
            highestPower1=(highestPower1*base1)%mod1;
            highestPower2=(highestPower2*base2)%mod2;
        }
        long hash1=0,hash2=0;
        for(int i=0;i<k;i++) {
            hash1=(hash1*base1+nums[i])%mod1;
            hash2=(hash2*base2 +nums[i])%mod2;
        }
        String key=hash1+"#"+hash2;
        map.put(key,map.getOrDefault(key,0)+1);
        for(int i=k;i<nums.length;i++){
            long[] hashes=rollingHash(hash1,hash2,nums[i-k],nums[i],highestPower1,highestPower2);
            hash1=hashes[0];
            hash2=hashes[1];
            key=hash1+"#"+hash2;
            map.put(key,map.getOrDefault(key,0)+1);
        }
        for(int freq : map.values()){
            if(freq==1) return true;
        }
        return false;
    }
    public int smallestUniqueSubarray(int[] nums) {
        int low=1;
        int high=nums.length;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(isValid(mid,nums))high=mid-1;
            else low=mid+1;
        }    
        return low;    
    }
}