public class Solution {
    
    public void sortColors(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return ;
        }
        
        int n=list.size();
        
        int i=0;
        int l=0;
        int r=n-1;
        
        while(i<=r && list.get(i)==0){
            i++;
            l++;
        }
        
        while(r>=0 && list.get(r)==2){
            r--;
        }
        
        while(i<=r){
            
            while(i<=r && list.get(i)==1){
                i++;
            }
            
            if(i>r){
                break;
            }
            
            if(list.get(i)==0){
                int temp=list.get(l);
                list.set(l,list.get(i));
                list.set(i,temp);
                i++;
                l++;
            }
            
            else if(list.get(i)==2){
                int temp=list.get(r);
                list.set(r,list.get(i));
                list.set(i,temp);
                r--;
            }
            
        }
        
        return ;
        
    }
}
