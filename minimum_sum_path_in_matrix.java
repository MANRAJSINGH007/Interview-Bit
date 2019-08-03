public class Solution {
    
    public static int func(ArrayList<ArrayList<Integer>> list, int n, int m, int i, int j, int[][] dp){
        
        if(i==n || j==m){
            return Integer.MAX_VALUE;
        }
        
        if(i==n-1 && j==m-1){
            return list.get(i).get(j);
        }
        
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        
        int x1=func(list,n,m,i+1,j,dp);
        int x2=func(list,n,m,i,j+1,dp);
        
        int min=Math.min(x1,x2);
        
        if(min!=Integer.MAX_VALUE){
            min+=list.get(i).get(j);
        }
        
        return dp[i][j]=min;
        
    }
    
    public int minPathSum(ArrayList<ArrayList<Integer>> list) {
        
        int n=list.size();
        if(n==0){
            return 0;
        }
        
        int m=list.get(0).size();
        
        int dp[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dp[i][j]=-1;
            }
        }
        
        return func(list,n,m,0,0,dp);
        
    }
}
