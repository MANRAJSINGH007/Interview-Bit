class Pair{
    
    int cost;
    ArrayList<Integer> ans;
    
    Pair(int cost, ArrayList<Integer> ans){
        this.cost=cost;
        this.ans=ans;
    }
    
}


public class Solution {
    
    public static Pair func(int n, ArrayList<Integer> list, boolean[] visited, int start, int end, Pair dp[][][]){
        
        int count=0;
        int mask=0;
        for(int i=0;i<n;i++){
            if(visited[i]){
                mask+=(int)Math.pow(2,i);
                count++;
            }
        }
        
        if(dp[start][end][mask]!=null){
            return dp[start][end][mask];
        }
        
        if(count==n){
            return dp[start][end][mask]=new Pair(0,new ArrayList<Integer>());
        }
        
        int min=Integer.MAX_VALUE;
        ArrayList<Integer> curr=new ArrayList<Integer>();
        
        for(int i=0;i<n;i++){
            if(!visited[i] && list.get(i)>=start && list.get(i)<=end){
                visited[i]=true;
                Pair left_cost=func(n,list,visited,start,list.get(i),dp);
                Pair right_cost=func(n,list,visited,list.get(i),end,dp);
                int small_cost=left_cost.cost+right_cost.cost+end-start+1;
                if(small_cost<min){
                    min=small_cost;
                    ArrayList<Integer> temp=new ArrayList<Integer>();
                    temp.add(list.get(i));
                    for(int p=0;p<left_cost.ans.size();p++){
                        temp.add(left_cost.ans.get(p));
                    }
                    for(int p=0;p<right_cost.ans.size();p++){
                        temp.add(right_cost.ans.get(p));
                    }
                    curr=temp;
                }
                visited[i]=false;
            }
        }
        
        return dp[start][end][mask]=new Pair(min,curr);
        
    }
    
    
    public ArrayList<Integer> rodCut(int m, ArrayList<Integer> list) {
        
        int n=list.size();
        boolean visited[]=new boolean[n+1];
        Pair dp[][][]=new Pair[m+1][m+1][(int)Math.pow(2,n)];
        
        return func(n,list,visited,0,m,dp).ans;
    }
}
