public class Solution {
    
    static int mod=(int)Math.pow(10,9)+7;
    
    public static int func(int n, HashMap<Integer,Integer> map){
        
        if(map.containsKey(n)){
            return map.get(n);
        }
        
        if(n==0){
            return 1;
        }
        
        int count=0;
        
        for(int i=2;i<=n;i+=2){
            long temp=((long)count+(((long)func(i-2,map))%mod*((long)func(n-i,map))%mod)%mod)%mod;
            count=(int)temp%mod;
        }
        
        map.put(n,count);
        
        return count;
        
    }
    
    public int chordCnt(int n) {
        
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        return func(2*n,map);
        
    }
}
