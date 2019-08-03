public class Solution {
    
    public static int func(String str, int i, int n, int[] dp){
        
        if(i==n){
            return 1;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        if(i==n-1){
            if(str.charAt(i)=='0'){
                return 0;
            }
            
            return 1;
        }
        
        if(str.charAt(i)=='0'){
            return 0;
        }
        
        int ways=0;
        
        String curr=str.substring(i,i+2);
        int num=Integer.parseInt(curr);
        
        if(num>=10 && num<=26){
            ways+=func(str,i+2,n,dp);
        }
        
        ways+=func(str,i+1,n,dp);
        
        
        return dp[i]=ways;
        
        
    }
    
    
    public int numDecodings(String str) {
        
        if(str==null){
            return 0;
        }
        
        int n=str.length();
        int dp[]=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        
        return func(str,0,n,dp);
        
    }
}
