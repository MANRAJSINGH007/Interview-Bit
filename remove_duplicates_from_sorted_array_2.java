public class Solution {
    public int removeDuplicates(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return 0;
        }
        
        int n=list.size();
        int prev=list.get(0);
        int flag=0;
        int index=1;
        
        for(int i=1;i<n;i++){
            
            int curr=list.get(i);
            if(curr==prev){
                if(flag==0){
                    flag=1;
                    list.set(index,curr);
                    index++;
                }
                else{
                    
                }
            }
            else{
                flag=0;
                list.set(index,curr);
                index++;
                prev=curr;
            }
        }
        
        return index;
        
    }
}
