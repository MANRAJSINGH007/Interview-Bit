public class Solution {
    public int firstMissingPositive(ArrayList<Integer> list) {
        
        int n=list.size();
        
        for(int i=0;i<n;i++){
            if(list.get(i)<0){
                list.set(i,n+1);
            }
        }
        
        for(int i=0;i<n;i++){
            
            int num=list.get(i);
            if(num>n){
                continue;
            }
            if(num<0){
                
                int place=-num-1;
                if(place>=n){
                    continue;
                }
                int next=list.get(place);
                if(next<=0){
                    
                }
                
                else{
                    list.set(place,-next);
                }
                
            }
            else if(num==0){
                
            }
            
            else{
                
                int place=num-1;
                if(place>=n){
                    continue;
                }
                int next=list.get(place);
                if(next>0){
                    list.set(place,-next);
                }
                
            }
            
        }
        
        
        for(int i=0;i<n;i++){
            
            if(list.get(i)>0){
                return i+1;
            }
            
        }
        
        return n+1;
        
        
        
    }
}
