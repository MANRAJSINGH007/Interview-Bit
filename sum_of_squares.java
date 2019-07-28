public class Solution {
    
    public static int func(int n){
        long mod=(long)Math.pow(10,9)+7;
        long ans=1;
        for(int i=1;i<n;i++){
            ans=(ans*2)%mod;
        }
        
        return (int)(ans%mod);
    }
    
    public int solve(int[] arr) {
        
        int n=arr.length;
        long sum=0;
        long mod = (long)Math.pow(10,9)+7;
        for(int i=0;i<n;i++){
            sum = sum+(long)Math.pow(arr[i],2);
            sum = sum%mod;
        }
        
        long ans=1;
        int mul=func(n);
        ans=(mul*sum)%mod;
        return (int)ans;
        
    }
}
