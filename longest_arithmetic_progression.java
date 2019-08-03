public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    
    public static int func(final List<Integer> list){
        
        int n=list.size();
        if(n==0){
            return 0;
        }
        HashMap<Integer,HashMap<Integer,Integer>> map=new HashMap<>();
        
        for(int i=0;i<n;i++){
            map.put(i,new HashMap<Integer,Integer>());
        }
        
        int maxi=1;
        
        for(int i=n-2;i>=0;i--){
            for(int j=i+1;j<n;j++){
                
                int diff=list.get(j)-list.get(i);
                
                if(map.get(i).containsKey(diff)){
                    if(map.get(j).containsKey(diff)){
                        int val=map.get(j).get(diff);
                        val++;
                        if(map.get(i).get(diff)<val){
                            map.get(i).put(diff,val);
                            maxi=Math.max(maxi,val);
                        }
                    }
                    else{
                        if(map.get(i).get(diff)<2){
                            map.get(i).put(diff,2);
                            maxi=Math.max(maxi,2);
                        }
                        
                    }
                }
                
                else{
                    if(map.get(j).containsKey(diff)){
                        int val=map.get(j).get(diff);
                        val++;
                        map.get(i).put(diff,val);
                        maxi=Math.max(maxi,val);
                    }
                    else{
                        map.get(i).put(diff,2);
                        maxi=Math.max(maxi,2);
                    }
                }
            }
        }
        
        return maxi;
        
    }
    
    public int solve(final List<Integer> list) {
        
        return func(list);
        
    }
}
