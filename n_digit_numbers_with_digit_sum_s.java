public class Solution {
    
    static int mod=(int)Math.pow(10,9)+7;
    
    public static int func(int n, int s, int[][] dp){
        
        if(n==0){
            if(s==0){
                return 1;
            }
            
            return 0;
        }
        
        if(dp[n][s]!=-1){
            return dp[n][s];
        }
        
        int ans=0;
        
        for(int i=0;i<=9;i++){
            if(s>=i)
                ans=(ans+func(n-1,s-i,dp))%mod;
        }
        
        return dp[n][s]=ans;
        
    }
    
    public int solve(int n, int s) {
        
        int dp[][]=new int[n+1][s+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=s;j++){
                dp[i][j]=-1;
            }
        }
        
        int ans=0;
        
        for(int i=1;i<=9;i++){
            if(s>=i)
                ans=(ans+func(n-1,s-i,dp))%mod;
        }
        
        return ans;
        
    }
}
