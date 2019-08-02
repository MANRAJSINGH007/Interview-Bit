class Pair{
    int x1;
    int x2;
    
    Pair(int x1, int x2){
        this.x1=x1;
        this.x2=x2;
    }
}

public class Solution {
    
    public static Pair func(String str, int start, int end, Pair[][] dp){
        
        if(start==end){
            if(str.charAt(start)=='T'){
                return new Pair(1,0);
            }
            
            return new Pair(0,1);
        }
        
        if(dp[start][end]!=null){
            return dp[start][end];
        }
        
        Pair ans=new Pair(0,0);
        
        for(int i=start;i<end;i++){
            
            if(str.charAt(i)=='&'){
                Pair l=func(str,start,i-1,dp);
                Pair r=func(str,i+1,end,dp);
                ans.x1 = (ans.x1 +( (l.x1%1003) * (r.x1%1003) )%1003 )% 1003;
                ans.x2 = (ans.x2 +( (l.x1%1003) * (r.x2%1003) )%1003 + ( (l.x2%1003) * (r.x1%1003) )%1003 +( (l.x2%1003) * (r.x2%1003) )%1003 )% 1003;
            }
            else if(str.charAt(i)=='|'){
                Pair l=func(str,start,i-1,dp);
                Pair r=func(str,i+1,end,dp);
                ans.x2 = (ans.x2 +( (l.x2%1003) * (r.x2%1003) )%1003 )% 1003;
                ans.x1 = (ans.x1 +( (l.x1%1003) * (r.x2%1003) )%1003 + ( (l.x2%1003) * (r.x1%1003) )%1003 +( (l.x1%1003) * (r.x1%1003) )%1003 )% 1003;
            }
            else if(str.charAt(i)=='^'){
                Pair l=func(str,start,i-1,dp);
                Pair r=func(str,i+1,end,dp);
                ans.x1 = (ans.x1 +( (l.x1%1003) * (r.x2%1003) )%1003 + ( (l.x2%1003) * (r.x1%1003) )%1003 )% 1003;
                ans.x2 = (ans.x2 +( (l.x1%1003) * (r.x1%1003) )%1003 + ( (l.x2%1003) * (r.x2%1003) )%1003 )% 1003;
            }
            
        }
        
        return dp[start][end]=ans;
        
    }
    
    public int cnttrue(String str) {
        
        int n=str.length();
        Pair dp[][]=new Pair[n][n];
        
        return func(str,0,n-1,dp).x1;
        
    }
}
