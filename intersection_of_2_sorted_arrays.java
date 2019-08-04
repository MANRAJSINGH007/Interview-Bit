public class Solution {
    // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int[] intersect(final int[] arr, final int[] brr) {
        
        int n=arr.length;
        int m=brr.length;
        
        ArrayList<Integer> list=new ArrayList<>();
        
        int i1=0;
        int i2=0;
        
        while(i1<n && i2<m){
            
            if(arr[i1]==brr[i2]){
                list.add(arr[i1]);
                i1++;
                i2++;
            }
            
            else if(arr[i1]<brr[i2]){
                i1++;
            }
            
            else{
                i2++;
            }
            
        }
        
        int ans[]=new int[list.size()];
        
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        
        return ans;
        
    }
}
