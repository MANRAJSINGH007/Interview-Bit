public class Solution {
    
    public static int func(String str, String s, int n, int m, int i, int j, int[][] dp){
        
        if(j==m){
            return 1;
        }
        
        if(i==n){
            return 0;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int m1=0;
        
        if(str.charAt(i)==s.charAt(j)){
            m1=func(str,s,n,m,i+1,j+1,dp);
        }
        
        return dp[i][j]=m1+func(str,s,n,m,i+1,j,dp);
        
    }
    
    
    public int numDistinct(String str, String s) {
        
        int n=str.length();
        int m=s.length();
        
        int dp[][]=new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        
        return func(str,s,n,m,0,0,dp);
    }
}
