public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public static int func(List<Integer> friend, List<Integer> capacity, List<Integer> cost, int n, int m, int i, int curr, int j, int[][][] dp){
        
        if(i==n){
            return 0;
        }
        
        if(dp[i][curr][j]!=-1){
            return dp[i][curr][j];
        }
        
        if(curr==0){
            
            if(i==n-1){
                return 0;
            }
            
            return dp[i][curr][j]=func(friend,capacity,cost,n,m,i+1,friend.get(i+1),0,dp);
        }
        
        if(j==m){
            return Integer.MAX_VALUE;
        }
        
        int c=0;
        int min=Integer.MAX_VALUE;
        int cos=0;
        
        while(c<=curr){
            
            int temp=func(friend,capacity,cost,n,m,i,curr-c,j+1,dp);
            
            if(temp!=Integer.MAX_VALUE){
                temp+=cos;
            }
            
            c+=capacity.get(j);
            cos+=cost.get(j);
            min=Math.min(temp,min);
            
        }
        
        return dp[i][curr][j]=min;
        
    }
    
    
    public int solve(final List<Integer> friend, final List<Integer> capacity, final List<Integer> cost) {
        
        int n=friend.size();
        int m=capacity.size();
        int max=friend.get(0);
        
        for(int i=1;i<n;i++){
            if(friend.get(i)>max){
                max=friend.get(i);
            }
        }
        int dp[][][]=new int[n+1][max+1][m+1];
        
        for(int i=0;i<=n;i++){
            for(int j=0;j<=max;j++){
                for(int k=0;k<=m;k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        
        return func(friend,capacity,cost,n,m,0,friend.get(0),0,dp);
        
    }
}
