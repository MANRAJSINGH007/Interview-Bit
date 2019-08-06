public class Solution {
    
    public static int func(String s1, String s2, String s3, int n, int m, int p, int i, int j, int k, int[][][] dp){
        
        if(k==p){
            if(i==n && j==m)
                return 1;
            return 0;
        }
        
        if(dp[i][j][k]!=-1){
            return dp[i][j][k];
        }
        
        if(i!=n){
            
            if(s1.charAt(i)==s3.charAt(k)){
                if(func(s1,s2,s3,n,m,p,i+1,j,k+1,dp)==1){
                    return dp[i][j][k]=1;
                }
            }
            
            if(func(s1,s2,s3,n,m,p,i+1,j,k,dp)==1){
                
                return dp[i][j][k]=1;
                
            }
            
        }
        
        if(j!=m){
            
            if(s2.charAt(j)==s3.charAt(k)){
                if(func(s1,s2,s3,n,m,p,i,j+1,k+1,dp)==1){
                    return dp[i][j][k]=1;
                }
            }
            
            if(func(s1,s2,s3,n,m,p,i,j+1,k,dp)==1){
                
                return dp[i][j][k]=1;
                
            }
            
        }
        
        return dp[i][j][k]=0;
        
    }
    
    
    public int isInterleave(String s1, String s2, String s3) {
        
        int n=s1.length();
        int m=s2.length();
        int p=s3.length();
        
        if(n+m!=p){
            return 0;
        }
        
        int dp[][][]=new int[n+1][m+1][p+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=m;j++){
                for(int k=0;k<=p;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return func(s1,s2,s3,n,m,p,0,0,0,dp);
        
        
    }
}
