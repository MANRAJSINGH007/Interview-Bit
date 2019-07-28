public class Solution {
    
    public static int gcd(int a, int b){
        if(b==0){
            return a;
        }
        
        return gcd(Math.min(a,b),(Math.max(a,b))%(Math.min(a,b)));
    }
    
    public static int func(int[] arr, int n, int i, int size, int[][] dp){
        
        if(size<=1 || i>=n-1){
            return 0;
        }
        
        if(dp[i][size]!=-1){
            return dp[i][size];
        }
        
        int max=func(arr,n,i+1,size,dp);
        
        int x1=arr[i];
        for(int k=i+1;k<n;k++){
            int temp=gcd(arr[i],arr[k]);
            int small=func(arr,n,k+1,size-2,dp);
            max=Math.max(max,temp+small);
        }
        
        return dp[i][size]=max;
        
    }
    
    
    public int solve(int[] arr, int size) {
        
        int n=arr.length;
        int dp[][]=new int[n][2*size+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<=2*size;j++){
                dp[i][j]=-1;
            }
        }
        
        return func(arr,n,0,2*size,dp);
        
    }
}
