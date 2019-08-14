public class Solution {
    public int nTriang(ArrayList<Integer> list) {
        
        if(list==null || list.size()==0){
            return 0;
        }
        
        int count=0;
        int n=list.size();
        
        int mod=(int)Math.pow(10,9)+7;
        
        Collections.sort(list);
        
        for(int j=n-1;j>=2;j--){
            
            int start=0;
            int end=j-1;
            int curr=list.get(j);
            
            while(start<end){
                int sum=list.get(start)+list.get(end);
                if(sum>curr){
                    count=(count+end-start)%mod;
                    end--;
                }
                else{
                    start++;
                }
            }
            
        }
        
        return count;
        
    }
}
