public class Solution {
    // DO NOT MODIFY THE LIST. IT IS READ ONLY
    public int minimize(final List<Integer> A, final List<Integer> B, final List<Integer> C){
        
        int n1=A.size();
        int n2=B.size();
        int n3=C.size();
        
        int i1=0;
        int i2=0;
        int i3=0;
        
        int min=Integer.MAX_VALUE;
        
        while(i1<n1 && i2<n2 && i3<n3){
            
            int x1=A.get(i1);
            int x2=B.get(i2);
            int x3=C.get(i3);
            
            int max=Math.max(Math.abs(x1-x2),Math.max(Math.abs(x1-x3),Math.abs(x2-x3)));
            
            min=Math.min(min,max);
            
            if(x1<=x2 && x1<=x3){
                i1++;
            }
            
            else if(x2<=x1 && x2<=x3){
                i2++;
            }
            
            else{
                i3++;
            }
            
        }
        
        return min;
        
        
    }
}
