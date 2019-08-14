public class Solution {
    public int maxArea(ArrayList<Integer> A) {
        
        if(A==null || A.size()==0){
            return 0;
        }
        
        int n=A.size();
        
        int st=0;
        int end=n-1;
        int max=0;
        
        while(st<end){
            
            max=Math.max(max,(end-st)*Math.min(A.get(st),A.get(end)));
            
            if(A.get(st)<A.get(end)){
                st++;
            }
            
            else{
                end--;
            }
            
        }
        
        return max;
    }
}
