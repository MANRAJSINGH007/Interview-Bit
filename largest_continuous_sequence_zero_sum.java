public class Solution {
    public ArrayList<Integer> lszero(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return new ArrayList<>();
        }
        
        int n=list.size();
        
        HashMap<Integer,Integer> map=new HashMap<>();
        
        int sum=0;
        int max=0;
        int left=-1;
        int right=-1;
        
        map.put(0,-1);
        
        for(int i=0;i<n;i++){
            
            sum+=list.get(i);
            
            if(map.containsKey(sum)){
                int j=map.get(sum)+1;
                if(max<i-j+1){
                    max=i-j+1;
                    left=j;
                    right=i;
                }
                else if(max==i-j+1){
                    if(j<left){
                        left=j;
                        right=i;
                    }
                }
            }
            
            if(!map.containsKey(sum)){
                map.put(sum,i);
            }
            
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        if(left==-1){
            return ans;
        }
        
        for(int i=left;i<=right;i++){
            ans.add(list.get(i));
        }
        
        return ans;
    }
}
