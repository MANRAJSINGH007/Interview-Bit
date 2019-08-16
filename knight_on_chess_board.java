class Pair{
    
    int x;
    int y;
    int ans;
    
    Pair(int x, int y, int ans){
        
        this.x=x;
        this.y=y;
        this.ans=ans;
        
    }
    
}

public class Solution {
    
    public int knight(int n, int m, int sx, int sy, int dx, int dy) {
        
        sx--;
        sy--;
        dx--;
        dy--;
        
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(sx,sy,0));
        
        boolean visited[][]=new boolean[n][m];
        
        visited[sx][sy]=true;
        
        
        while(!q.isEmpty()){
            
            Pair curr=q.remove();
            if(curr.x==dx && curr.y==dy){
                return curr.ans;
            }
            
            int i=curr.x;
            int j=curr.y;
            
            if(i>0 && i<n && j>1 && j<m && !visited[i-1][j-2]){
                visited[i-1][j-2]=true;
                if(i-1==dx && j-2==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i-1,j-2,curr.ans+1));
            }
            
            if(i>=0 && i<n-1 && j>=0 && j<m-2 && !visited[i+1][j+2]){
                visited[i+1][j+2]=true;
                if(i+1==dx && j+2==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i+1,j+2,curr.ans+1));
            }
            
            if(i>=0 && i<n-1 && j>=2 && j<m && !visited[i+1][j-2]){
                visited[i+1][j-2]=true;
                if(i+1==dx && j-2==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i+1,j-2,curr.ans+1));
            }
            
            if(i>=0 && i<n-2 && j>0 && j<m && !visited[i+2][j-1]){
                visited[i+2][j-1]=true;
                if(i+2==dx && j-1==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i+2,j-1,curr.ans+1));
            }
            
            if(i>=0 && i<n-2 && j>=0 && j<m-1 && !visited[i+2][j+1]){
                visited[i+2][j+1]=true;
                if(i+2==dx && j+1==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i+2,j+1,curr.ans+1));
            }
            
            if(i>1 && i<n && j>=0 && j<m-1 && !visited[i-2][j+1]){
                visited[i-2][j+1]=true;
                if(i-2==dx && j+1==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i-2,j+1,curr.ans+1));
            }
            
            if(i>1 && i<n && j>0 && j<m && !visited[i-2][j-1]){
                visited[i-2][j-1]=true;
                if(i-2==dx && j-1==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i-2,j-1,curr.ans+1));
            }
            
            if(i>0 && i<n && j>=0 && j<m-2 && !visited[i-1][j+2]){
                visited[i-1][j+2]=true;
                if(i-1==dx && j+2==dy){
                    return curr.ans+1;
                }
                
                q.add(new Pair(i-1,j+2,curr.ans+1));
            }
            
            
        }
        
        return -1;
        
    }
}
