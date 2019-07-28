public class Solution {
    
    public static int func(int n){
        long ans=1;
        long mod=(long)Math.pow(10,9)+6;
        for(int i=1;i<n;i++){
            ans=(ans*2)%mod;
        }
        
        return (int)(ans%mod);
    }
    
    public static int func2(int val, int num){
        if(val==0){
            return 1;
        }
        
        if(val==1){
            return num;
        }
        
        long ans=1;
        long mod=(long)Math.pow(10,9)+7;
        long temp=(long)func2(val/2,num);
        temp=(temp*temp)%mod;
        if(val%2!=0){
            temp=(temp*num)%mod;
        }
        
        return (int)temp;
    }
    
    public int solve(int[] arr) {
        
        int n=arr.length;
        if(n==0){
            return 1;
        }
        
        int max=arr[0];
        for(int i=1;i<n;i++){
            max=Math.max(max,arr[i]);
        }
        
        boolean[] prime=new boolean[max+1];
        
        for(int i=2;i<=max;i++){
            prime[i]=true;
        }
        
        for(int i=2;i<=max;i++){
            if(prime[i]){
                for(int j=i*i;j<=max;j+=i){
                    prime[j]=false;
                }
            }
        }
        
        int mul=func(n);
        long mod=(long)Math.pow(10,9)+7;
        long ans=1;
        for(int i=0;i<n;i++){
            if(prime[arr[i]]){
                ans=(ans*func2(mul,arr[i]))%mod;
            }
        }
        
        return (int)ans;
    }
}
