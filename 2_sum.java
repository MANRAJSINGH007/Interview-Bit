public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public ArrayList<Integer> twoSum(final List<Integer> list, int x) {
    
        if(list==null || list.size()<=1){
            return new ArrayList<>();
        }
        
        int n=list.size();
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int min_index1=n;
        int min_index2=n;
        
        for(int i=0;i<n;i++){
            
            int element=list.get(i);
            int index2=i;
            
            if(map.containsKey(x-element)){
                int index1=map.get(x-element);
                
                if(index2<min_index2){
                    min_index2=index2;
                    min_index1=index1;
                }
            }
            
            if(!map.containsKey(element)){
                map.put(element,i);
            }
            
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(min_index1!=n && min_index2!=n){
            ans.add(min_index1+1);
            ans.add(min_index2+1);
        }
        
        return ans;
        
    }
}
