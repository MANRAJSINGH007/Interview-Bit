public class Solution {
    public int adjacent(ArrayList<ArrayList<Integer>> list) {
        
        if(list==null || list.size()==0){
            return 0;
        }
        
        int n=list.get(0).size();
        
        if(n==0){
            return 0;
        }
        
        int m1=0;
        int m2=Math.max(list.get(0).get(0),list.get(1).get(0));
        
        for(int i=1;i<n;i++){
            int temp=m1+Math.max(list.get(0).get(i),list.get(1).get(i));
            if(temp>=m2){
                m1=m2;
                m2=temp;
            }
            else{
                m1=m2;
            }
        }
        
        return m2;
        
    }
}
