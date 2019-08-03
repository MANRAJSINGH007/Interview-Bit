public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public static int func(final List<Integer> list, int i, int n, int[] dp){
        
        if(i==n){
            return 0;
        }
        
        if(dp[i]!=-1){
            return dp[i];
        }
        
        int ans=func(list,i+1,n,dp);
        
        for(int j=i+1;j<n;j++){
            if(list.get(j)>list.get(i))
                ans=Math.max(ans,list.get(j)-list.get(i)+func(list,j+1,n,dp));
        }
        
        return dp[i]=ans;
        
        
    }
    
    public static int func3(final List<Integer> list){
        
        int n=list.size();
        
        int max=0;
        int prev=list.get(0);
        
        for(int i=1;i<n;i++){
            if(list.get(i)>prev){
                max+=list.get(i)-prev;
            }
            
            prev=list.get(i);
        }
        
        return max;
        
    }
    
    public static int func2(final List<Integer> list){
        
        int n=list.size();
        
        int ans[]=new int[n];
        
        for(int i=n-2;i>=0;i--){
            
            ans[i]=ans[i+1];
            for(int j=i+1;j<n;j++){
                if(list.get(j)>list.get(i)){
                    int temp=list.get(j)-list.get(i);
                    if(j+1<n){
                        temp+=ans[j+1];
                    }
                    ans[i]=Math.max(ans[i],temp);
                }
            }
            
        }
        
        return ans[0];
        
    }
    
    
    public int maxProfit(final List<Integer> list) {
        
        int n=list.size();
        if(n==0 || n==1){
            return 0;
        }
        
        return func3(list);
        
        // int dp[]=new int[n];
        // for(int i=0;i<n;i++){
        //     dp[i]=-1;
        // }
        
        // return func(list,0,n,dp);
        
    }
}
