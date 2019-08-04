public class Solution {
    
    public static int func(int[][] arr, int n, int m, int i, int j, int[][] dp){
        
        if(i==n || j==m || arr[i][j]==1){
            return 0;
        }
        
        if(i==n-1 && j==m-1){
            return 1;
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        arr[i][j]=1;
        
        int ans=func(arr,n,m,i+1,j,dp);
        ans+=func(arr,n,m,i,j+1,dp);
        
        arr[i][j]=0;
        
        return dp[i][j]=ans;
        
        
    }
    
    public int uniquePathsWithObstacles(int[][] arr) {
        
        int n=arr.length;
        int m=arr[0].length;
        
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        
        return func(arr,n,m,0,0,dp);
    }
}
