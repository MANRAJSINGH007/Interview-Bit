public class Solution {
    
    public int removeElement(ArrayList<Integer> list, int x) {
    
        if(list==null || list.size()==0){
            return 0;
        }
        
        int n=list.size();
        int index=0;
        
        for(int i=0;i<n;i++){
            
            int curr=list.get(i);
            if(curr!=x){
                list.set(index,curr);
                index++;
            }
        }
        
        return index;
        
    }
}
