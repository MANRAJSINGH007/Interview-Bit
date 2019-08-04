public class Solution {
    
    public static int func(int x1, int x2, int x3){
        
        int max=Math.max(x1,Math.max(x2,x3));
        int min=Math.min(x1,Math.min(x2,x3));
        
        return Math.abs(max-min);
        
    }
    
    
    public int solve(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> c) {
        
        int n1=a.size();
        int n2=b.size();
        int n3=c.size();
        
        int i1=0;
        int i2=0;
        int i3=0;
        
        int min=Integer.MAX_VALUE;
        
        while(i1<n1 && i2<n2 && i3<n3){
            
            int x1=a.get(i1);
            int x2=b.get(i2);
            int x3=c.get(i3);
            
            min=Math.min(min,func(x1,x2,x3));
            
            if(x1<=x2 && x1<=x3){
                i1++;
            }
            
            if(x2<=x1 && x2<=x3){
                i2++;
            }
            
            if(x3<=x2 && x1>=x3){
                i3++;
            }
            
        }
        
        return min;
        
    }
}
