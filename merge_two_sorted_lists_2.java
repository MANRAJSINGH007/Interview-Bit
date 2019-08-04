public class Solution {
    
    public void merge(ArrayList<Integer> a, ArrayList<Integer> b) {
    
        if(b==null){
            return ;
        }
        
        if(a==null){
            a=b;
            return ;
        }
        
        ArrayList<Integer> ans=new ArrayList<>();
        
        int i1=0;
        int i2=0;
        
        while(i1<a.size() && i2<b.size()){
            if(a.get(i1)<=b.get(i2)){
                ans.add(a.get(i1));
                i1++;
            }
            else{
                ans.add(b.get(i2));
                i2++;
            }
        }
        
        while(i1<a.size()){
            ans.add(a.get(i1));
            i1++;
        }
        
        while(i2<b.size()){
            ans.add(b.get(i2));
            i2++;
        }
        
        while(a.size()>0){
            a.remove(0);
        }
        
        for(int i=0;i<ans.size();i++){
            a.add(ans.get(i));
        }
        
        return ;
        
    }
}
