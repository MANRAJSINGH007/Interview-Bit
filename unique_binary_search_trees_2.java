public class Solution {
    
    public static int func(int n, int[] dp){
        
        if(n==0 || n==1){
            return 1;
        }
        
        if(dp[n]!=-1){
            return dp[n];
        }
        
        int ans=0;
        for(int i=1;i<=n;i++){
            ans+=func(i-1,dp)*func(n-i,dp);
        }
        
        return dp[n]=ans;
        
    }
    
    
    public int numTrees(int n) {
        
        if(n==0){
            return 1;
        }
        
        int dp[]=new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i]=-1;
        }
        
        return func(n,dp);
    }
}
