public class Solution {
    public void rotate(ArrayList<ArrayList<Integer>> a) {
        
        int n=a.size();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<=i;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(j).get(i));
                a.get(j).set(i,temp);
            }
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp=a.get(i).get(j);
                a.get(i).set(j,a.get(i).get(n-1-j));
                a.get(i).set(n-1-j,temp);
            }
        }
        
        return ;
        
    }
}
